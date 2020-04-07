import {Scenario, getPretender} from 'ember-data-factory-guy';
import 'faker'; // used in the factories

// Just for fun, set the log level ( to 1 ) and see all FactoryGuy response info in console
Scenario.settings({
  logLevel: 1, // 1 is the max for now, default is 0
});

export default class extends Scenario {
  run() {
    this.mockFindAll('feedmessage', 20);
    this.mockFindAll('user', 15)
      // .get()
      // .forEach(({ id }) => {
      //   this.mockFindRecord('user').returns({ id });
      // })
    this.mockFindAll('file', 15);
    this.mockFindAll('group', 10);

    // for(let i = 0; i < 15; i++) {
    this.mockFindRecord('group'); // seems not to work?
    // }

    this.mockQuery('chatmessage').returns({ json: this.buildList('chatmessage', 10) });

    getPretender().post('*', getPretender().passthrough);
    getPretender().get('*', getPretender().passthrough);
    getPretender().patch('*', getPretender().passthrough);
  }
}
