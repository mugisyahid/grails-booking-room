package com.ligarisma.booking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReservedRoomServiceSpec extends Specification {

    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ReservedRoom(...).save(flush: true, failOnError: true)
        //new ReservedRoom(...).save(flush: true, failOnError: true)
        //ReservedRoom reservedRoom = new ReservedRoom(...).save(flush: true, failOnError: true)
        //new ReservedRoom(...).save(flush: true, failOnError: true)
        //new ReservedRoom(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reservedRoom.id
    }

    void "test get"() {
        setupData()

        expect:
        reservedRoomService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ReservedRoom> reservedRoomList = reservedRoomService.list(max: 2, offset: 2)

        then:
        reservedRoomList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reservedRoomService.count() == 5
    }

    void "test delete"() {
        Long reservedRoomId = setupData()

        expect:
        reservedRoomService.count() == 5

        when:
        reservedRoomService.delete(reservedRoomId)
        sessionFactory.currentSession.flush()

        then:
        reservedRoomService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ReservedRoom reservedRoom = new ReservedRoom()
        reservedRoomService.save(reservedRoom)

        then:
        reservedRoom.id != null
    }
}
