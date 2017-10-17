package com.ligarisma.booking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OccupiedRoomServiceSpec extends Specification {

    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OccupiedRoom(...).save(flush: true, failOnError: true)
        //new OccupiedRoom(...).save(flush: true, failOnError: true)
        //OccupiedRoom occupiedRoom = new OccupiedRoom(...).save(flush: true, failOnError: true)
        //new OccupiedRoom(...).save(flush: true, failOnError: true)
        //new OccupiedRoom(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //occupiedRoom.id
    }

    void "test get"() {
        setupData()

        expect:
        occupiedRoomService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OccupiedRoom> occupiedRoomList = occupiedRoomService.list(max: 2, offset: 2)

        then:
        occupiedRoomList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        occupiedRoomService.count() == 5
    }

    void "test delete"() {
        Long occupiedRoomId = setupData()

        expect:
        occupiedRoomService.count() == 5

        when:
        occupiedRoomService.delete(occupiedRoomId)
        sessionFactory.currentSession.flush()

        then:
        occupiedRoomService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OccupiedRoom occupiedRoom = new OccupiedRoom()
        occupiedRoomService.save(occupiedRoom)

        then:
        occupiedRoom.id != null
    }
}
