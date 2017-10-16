package com.ligarisma.booking

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RoomTypeServiceSpec extends Specification {

    RoomTypeService roomTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RoomType(...).save(flush: true, failOnError: true)
        //new RoomType(...).save(flush: true, failOnError: true)
        //RoomType roomType = new RoomType(...).save(flush: true, failOnError: true)
        //new RoomType(...).save(flush: true, failOnError: true)
        //new RoomType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //roomType.id
    }

    void "test get"() {
        setupData()

        expect:
        roomTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RoomType> roomTypeList = roomTypeService.list(max: 2, offset: 2)

        then:
        roomTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        roomTypeService.count() == 5
    }

    void "test delete"() {
        Long roomTypeId = setupData()

        expect:
        roomTypeService.count() == 5

        when:
        roomTypeService.delete(roomTypeId)
        sessionFactory.currentSession.flush()

        then:
        roomTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RoomType roomType = new RoomType()
        roomTypeService.save(roomType)

        then:
        roomType.id != null
    }
}
