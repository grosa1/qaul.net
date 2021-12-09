// Copyright (c) 2021 Open Community Project Association https://ocpa.ch
// This software is published under the AGPLv3 license.

package net.qaul.ble.service

import android.bluetooth.*
import android.bluetooth.le.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.ParcelUuid
import androidx.lifecycle.LifecycleService
import net.qaul.ble.AppLog
import net.qaul.ble.RemoteLog
import net.qaul.ble.model.BLEScanDevice
import java.util.*

class BleService : LifecycleService() {
    private val TAG: String = BleService::class.java.simpleName
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var bleResponseCallback: BleResponseCallback? = null
    private val SERVICE_UUID = "99E91399-80ED-4943-9BCB-39C532A76023"
    private val READ_CHAR = "99E91401-80ED-4943-9BCB-39C532A76023"
    private var qaulId: ByteArray? = null
    private var advertMode = ""
    private var bluetoothLeAdvertiser: BluetoothLeAdvertiser? = null
    private var gattServer: BluetoothGattServer? = null
    private var bluetoothManager: BluetoothManager? = null

    private lateinit var scanCallback: ScanCallback
    private lateinit var timeOutRunnable: Runnable
    private lateinit var bleScanner: BluetoothLeScanner
    private val handler = Handler(Looper.getMainLooper())
    private val devicesList = arrayListOf<BLEScanDevice>()
    private val uuidList = arrayListOf<ParcelUuid>()
    private var filters: ArrayList<ScanFilter> = arrayListOf()
    private var scanSettings: ScanSettings? = null
    private var mBluetoothGatt: BluetoothGatt? = null
    private val descriptorWriteQueue: Queue<BluetoothGattDescriptor> = LinkedList()
    private var failTimer: Timer? = null
    var disconnectedFromDevice = false
    var device: BluetoothDevice? = null

    companion object {
        const val SCAN_TIME_OUT: Long = 300000 // millisecond
        const val RESCAN_DEVICE: Long = 5000
        var bleService: BleService? = null
        var isAdvertisementRunning = false
        var isScanningRunning = false
        var offset = 0
    }

    override fun onCreate() {
        super.onCreate()
        bleService = this
        AppLog.e(TAG, "$TAG created")
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        AppLog.e(TAG, "$TAG started")
    }

    /**
     * This Method Will Set Necessary Data for Staring Advertisement
     */
    fun setData(
        qaul_id: ByteArray,
        mode: String, bleCallback: BleResponseCallback
    ) {
        bleService?.qaulId = qaul_id
        bleService?.advertMode = mode
        bleService?.bleResponseCallback = bleCallback
        setupAdvertiser()
    }


    /**
     * This Method Will Start the Service
     */
    fun start(
        context: Context
    ) {
        if (bleService == null) {
            val intent = Intent(context, BleService::class.java)
            context.startService(intent)
        } else {
            AppLog.e(TAG, "$TAG already started")
        }
    }

    /**
     * This Method Will Return True if Service is Running
     */
    fun isRunning(): Boolean {
        return bleService != null
    }

    /**
     * This Method Will Return True if Advertisement is ON
     */
    fun isAdvertiserRunning(): Boolean {
        return isAdvertisementRunning
    }

    /**
     * This Method Will Stop the Service if It Is Running
     */
    fun stop() {
        if (bleService != null) {
            var str = "$TAG stopped"
            if (bleService!!.isAdvertiserRunning()) {
                bluetoothLeAdvertiser?.stopAdvertising(advertiseCallback)
                gattServer?.clearServices()
                gattServer?.close()
                str = str.plus(" advertisement stopped")
            }
            bleService?.stopSelf()
            bleService?.bleResponseCallback?.bleAdvertStopRes(
                status = true,
                errorText = str
            )
        } else {
            bleService?.bleResponseCallback?.bleAdvertStopRes(
                status = false,
                errorText = "$TAG not started"
            )
            AppLog.e(TAG, "$TAG not started")
        }
    }

    /**
     * This Method Will Set Service, Characteristic & Other Data to Run Advertiser
     */
    private fun setupAdvertiser() {
        val t = Thread {
            bluetoothManager = bleService!!.getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
            bluetoothAdapter = bluetoothManager!!.adapter
            bluetoothAdapter!!.name = "Qaul"
            bluetoothLeAdvertiser = bluetoothAdapter!!.bluetoothLeAdvertiser
            if (Build.VERSION.SDK_INT > 21) {
                if (bluetoothAdapter != null) {
                    AppLog.e(
                        TAG,
                        "Peripheral supported"
                    )
                    val firstService = BluetoothGattService(
                        UUID.fromString(SERVICE_UUID),
                        BluetoothGattService.SERVICE_TYPE_PRIMARY
                    )
                    val firstServiceChar = BluetoothGattCharacteristic(
                        UUID.fromString(READ_CHAR),
                        BluetoothGattCharacteristic.PROPERTY_READ,
                        BluetoothGattCharacteristic.PERMISSION_READ
                    )

                    firstServiceChar.setValue(qaulId)
                    firstService.addCharacteristic(firstServiceChar)
                    startAdvertisement(service = firstService)
                } else {
                    AppLog.e(
                        TAG,
                        "Peripheral not supported"
                    )
                }
            } else {
                AppLog.e(
                    TAG,
                    "Peripheral not supported"
                )
            }
        }
        t.start()
    }

    /**
     * This Method Will Start Advertisement According to Configuration
     */
    private fun startAdvertisement(service: BluetoothGattService) {
        startGattServer(service = service)
        val dataBuilder = AdvertiseData.Builder()
        val settingsBuilder = AdvertiseSettings.Builder()
        dataBuilder.setIncludeTxPowerLevel(true)
        val uuid = ParcelUuid(UUID.fromString(SERVICE_UUID))
        dataBuilder.addServiceUuid(uuid)
        dataBuilder.setIncludeDeviceName(true)
        when (advertMode) {
            "low_power" -> {
                settingsBuilder
                    .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_POWER)
            }
            "balanced" -> {
                settingsBuilder
                    .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_BALANCED)
            }
            "low_latency" -> {
                settingsBuilder
                    .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY)
            }
            "UNRECOGNIZED" -> {
                settingsBuilder
                    .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY)
            }
        }
        settingsBuilder
            .setTxPowerLevel(AdvertiseSettings.ADVERTISE_TX_POWER_HIGH)
        settingsBuilder.setConnectable(true)

        bluetoothLeAdvertiser!!.startAdvertising(
            settingsBuilder.build(),
            dataBuilder.build(), advertiseCallback
        )
    }

    /**
     * This Method Will Set Filter, ScanMode & Other Data to Start Scanning
     */
    private fun setupScanning() {
        bleScanner = BluetoothAdapter.getDefaultAdapter().bluetoothLeScanner
        timeOutRunnable = Runnable {
//                onScanfailed(BLEErrorType.TIME_OUT)
        }
        val uuid = ParcelUuid.fromString(SERVICE_UUID)
        uuidList.add(uuid)
        setFilter(uuidList)
        scanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult?) {
                super.onScanResult(callbackType, result)
                AppLog.d(TAG, "device : " + result!!.device.address)
                RemoteLog[this@BleService]!!.addDebugLog("$TAG:device : " + result.device.address)
                parseBLEFrame(result.device, result.rssi, result)
            }

            override fun onScanFailed(errorCode: Int) {
                super.onScanFailed(errorCode)
                onScanfailed()
                stopScan()
            }
        }


        scanSettings =
            ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build()


        bleScanner.startScan(filters, scanSettings, scanCallback)
        handler.postDelayed(timeOutRunnable, SCAN_TIME_OUT)
    }

    private fun onScanfailed() {
        //Todo Send Response to UI of Scan Failure
    }

    private fun setFilter(uuidList: ArrayList<ParcelUuid>) {

        for (uuid in uuidList) {
            filters.add(
                ScanFilter.Builder().setServiceUuid(uuid).build()
            )
        }
    }

    private fun parseBLEFrame(device: BluetoothDevice, rssi: Int, result: ScanResult) {
        handler.removeCallbacks(timeOutRunnable)
        AppLog.d(TAG, "device : " + device.address)
        val selectItem = devicesList.find { it.macAddress == device.address }
        if (selectItem == null) {
            AppLog.e(TAG, "device : " + device.address)
            AppLog.e(TAG, "UUID : " + result.scanRecord!!.serviceUuids)
            RemoteLog[this]!!.addDebugLog("$TAG:device : " + device.address + " " + result.scanRecord!!.serviceUuids)
            val bleDevice: BLEScanDevice = BLEScanDevice.getDevice()
            bleDevice.bluetoothDevice = device
            bleDevice.scanResult = result
            bleDevice.name = device.name
            bleDevice.deviceRSSI.set(rssi)
            bleDevice.macAddress = device.address
            deviceFound(bleDevice)
        } else {
            selectItem.deviceRSSI.set(rssi)
            selectItem.scanResult = result
            selectItem.name = device.name
//            deviceFound(selectItem)
        }
    }

    private fun deviceFound(bleDevice: BLEScanDevice) {
        //Todo Send response to UI
    }

    fun stopScan() {
        AppLog.e(TAG, "stopScan()")
        isScanningRunning = false
        bleScanner.stopScan(scanCallback)
        RemoteLog[this]!!.addDebugLog("$TAG:Scanning Stopped")
    }


    private fun refreshDeviceCache(gatt: BluetoothGatt?) {
        try {
            val localMethod = gatt?.javaClass?.getMethod("refresh", *arrayOfNulls(0))
            localMethod?.invoke(gatt, *arrayOfNulls(0))
        } catch (localException: Exception) {
        }
    }

    /**
     * This Method Will Start the GattServer.
     */
    private fun startGattServer(service: BluetoothGattService) {
        gattServer = bluetoothManager!!.openGattServer(
            this,
            gattServerCallback
        )
        gattServer?.addService(service)
    }

    /**
     * This is a Object of a BluetoothGattServer with it's Callback.
     */
    private var gattServerCallback: BluetoothGattServerCallback =
        object : BluetoothGattServerCallback() {
            override fun onConnectionStateChange(
                device: BluetoothDevice, status: Int,
                newState: Int
            ) {
                super.onConnectionStateChange(device, status, newState)
            }

            override fun onServiceAdded(status: Int, service: BluetoothGattService) {
                super.onServiceAdded(status, service)
            }

            override fun onCharacteristicReadRequest(
                device: BluetoothDevice,
                requestId: Int, offset: Int,
                characteristic: BluetoothGattCharacteristic
            ) {
                super.onCharacteristicReadRequest(
                    device, requestId, offset,
                    characteristic
                )
                AppLog.e(TAG, "Request Received : " + qaulId?.size)
                gattServer?.sendResponse(
                    device,
                    requestId,
                    0,
                    0,
                    qaulId
                )
            }

            private fun getStoredValue(characteristic: BluetoothGattCharacteristic): ByteArray {
                val `val` = ByteArray(characteristic.value.size)
                System.arraycopy(
                    characteristic.value, 0, `val`, 0,
                    characteristic.value.size
                )

                return `val`
            }

            override fun onCharacteristicWriteRequest(
                device: BluetoothDevice,
                requestId: Int, characteristic: BluetoothGattCharacteristic,
                preparedWrite: Boolean, responseNeeded: Boolean, offset: Int,
                value: ByteArray
            ) {
                super.onCharacteristicWriteRequest(
                    device, requestId,
                    characteristic, preparedWrite, responseNeeded, offset,
                    value
                )
            }

            override fun onDescriptorReadRequest(
                device: BluetoothDevice,
                requestId: Int,
                offset: Int,
                descriptor: BluetoothGattDescriptor
            ) {
                super.onDescriptorReadRequest(device, requestId, offset, descriptor)
            }

            override fun onDescriptorWriteRequest(
                device: BluetoothDevice,
                requestId: Int,
                descriptor: BluetoothGattDescriptor,
                preparedWrite: Boolean,
                responseNeeded: Boolean,
                offset: Int,
                value: ByteArray
            ) {
                super.onDescriptorWriteRequest(
                    device,
                    requestId,
                    descriptor,
                    preparedWrite,
                    responseNeeded,
                    offset,
                    value
                )
            }

            override fun onExecuteWrite(device: BluetoothDevice, requestId: Int, execute: Boolean) {
                super.onExecuteWrite(device, requestId, execute)
            }

            override fun onNotificationSent(device: BluetoothDevice, status: Int) {
                super.onNotificationSent(device, status)
            }
        }

    /**
     * This is a Object of a AdvertiseCallback.
     */
    private val advertiseCallback: AdvertiseCallback = object : AdvertiseCallback() {
        override fun onStartSuccess(advertiseSettings: AdvertiseSettings) {
            val successMsg = "Advertisement successful"
            isAdvertisementRunning = true
            AppLog.e(TAG, successMsg)
            bleService?.bleResponseCallback?.bleAdvertStartRes(
                status = true,
                errorText = successMsg,
                unknownError = false
            )
        }

        override fun onStartFailure(i: Int) {
            var unknownError = false
            isAdvertisementRunning = false
            var errorText = ""
            if (i < 1 || i > 5) {
                unknownError = true
            }
            when (i) {
                1 -> {
                    errorText = "ADVERTISE_FAILED_DATA_TOO_LARGE"
                }
                2 -> {
                    errorText = "ADVERTISE_FAILED_TOO_MANY_ADVERTISERS"
                }
                3 -> {
                    errorText = "ADVERTISE_FAILED_ALREADY_STARTED"
                }
                4 -> {
                    errorText = "ADVERTISE_FAILED_INTERNAL_ERROR"
                }
                5 -> {
                    errorText = "ADVERTISE_FAILED_FEATURE_UNSUPPORTED"
                }
            }

            val failMsg = "Advertisement failed: $errorText"
            AppLog.e(TAG, failMsg)
            bleService?.bleResponseCallback?.bleAdvertStartRes(
                status = false,
                errorText = failMsg,
                unknownError = unknownError
            )
        }
    }

    /**
     * This method Will be Called When Service Will Stopped/Destroyed
     */
    override fun onDestroy() {
        if (bleService != null) {
            if (bleService!!.isAdvertiserRunning()) {
                bluetoothLeAdvertiser?.stopAdvertising(advertiseCallback)
                gattServer?.clearServices()
                gattServer?.close()
            }
            bleService?.stopSelf()
        }
        bleService = null
        super.onDestroy()
    }

    /**
     * This is a Interface for Sending Advertisement Start & Stop Response to BLEWrapperClass.
     */
    interface BleResponseCallback {
        fun bleAdvertStartRes(status: Boolean, errorText: String, unknownError: Boolean)
        fun bleAdvertStopRes(status: Boolean, errorText: String)
        fun bleDeviceFound(bleDevice: BLEScanDevice)
//        fun bleDeviceOutRange(bleDevice: BLEScanDevice)
//        fun bleScanFailed(error: String)
    }
}