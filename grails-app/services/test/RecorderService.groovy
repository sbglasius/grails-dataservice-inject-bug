package test

import grails.events.annotation.Subscriber
import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.grails.datastore.mapping.engine.event.PostUpdateEvent

import java.time.LocalDateTime

@Transactional
class RecorderService {

    RecorderDataService recorderDataService

    @Subscriber
    void afterInsert(PostInsertEvent event) {
        handleEvent(event)
    }

    @Subscriber
    void afterUpdate(PostUpdateEvent event) {
        handleEvent(event)
    }

    void handleEvent(AbstractPersistenceEvent event) {
        if (event.entityObject instanceof Test) {
            log.info("Handling event of $event.eventType")
            recorderDataService.save(event.entityObject as Test, LocalDateTime.now())
        }
    }
}
