package test

import grails.gorm.services.Service

@Service(Test)
interface TestDataService {

    Test save(String name)

    Long count()
}
