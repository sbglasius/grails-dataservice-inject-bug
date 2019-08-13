package test

import grails.gorm.services.Service

import java.time.LocalDateTime

@Service(Recorder)
interface RecorderDataService {

    Recorder save(Test test, LocalDateTime recorded)

    Long count()
}
