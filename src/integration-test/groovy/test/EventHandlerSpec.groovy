package test

import grails.testing.mixin.integration.Integration
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

@Integration
class EventHandlerSpec extends Specification {
    TestDataService testDataService
    RecorderDataService recorderDataService
    void "test that when saving a Test object, a Recorded object is also created"() {
        given:
            def conditions = new PollingConditions(timeout: 5)

        when:
            testDataService.save('A name')

        then:
            testDataService.count() == old(testDataService.count()) + 1
            conditions.eventually {
                assert recorderDataService.count() == old(recorderDataService.count()) + 1
            }
    }

}
