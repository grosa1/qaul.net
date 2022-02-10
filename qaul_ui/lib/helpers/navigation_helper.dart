import 'package:flutter/cupertino.dart';
import 'package:qaul_ui/screens/about_screen.dart';
import 'package:qaul_ui/screens/create_account_screen.dart';
import 'package:qaul_ui/screens/home/home_screen.dart';
import 'package:qaul_ui/screens/settings_screen.dart';

import '../screens/splash_screen.dart';

class NavigationHelper {
  static const initial = '/';
  static const createAccount = '/createAccount';
  static const home = '/home';
  static const settings = '/settings';
  static const about = '/about';

  static Route<T> _buildRoute<T>(final RouteSettings settings, final WidgetBuilder page) =>
      CupertinoPageRoute(builder: page, settings: settings);

  static Route<dynamic> onGenerateRoute(final RouteSettings _settings) {
    Widget routeWidget = const SizedBox.shrink();
    switch (_settings.name) {
      case initial:
        routeWidget = WillPopScope(onWillPop: () async => false, child: SplashScreen());
        break;
      case createAccount:
        routeWidget = WillPopScope(onWillPop: () async => false, child: CreateAccountScreen());
        break;
      case home:
        // WillPopScope handled in build method of HomeScreen -> Custom behavior
        routeWidget = HomeScreen();
        break;
      case settings:
        routeWidget = const SettingsScreen();
        break;
      case about:
        routeWidget = const AboutScreen();
        break;
      default:
        throw ArgumentError.value(
            _settings.name, 'Route name', 'Handle this route in NavigationHelper.');
    }

    return _buildRoute(_settings, (context) => routeWidget);
  }
}
