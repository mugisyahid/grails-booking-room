package com.ligarisma.booking

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GuestServiceSpec extends Specification {

    GuestService guestService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Guest(...).save(flush: true, failOnError: true)
        //new Guest(...).save(flush: true, failOnError: true)
        //Guest guest = new Guest(...).save(flush: true, failOnError: true)
        //new Guest(...).save(flush: true, failOnError: true)
        //new Guest(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //guest.id
    }

    void "test get"() {
        setupData()

        expect:
        guestService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Guest> guestList = guestService.list(max: 2, offset: 2)

        then:
        guestList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        guestService.count() == 5
    }

    void "test delete"() {
        Long guestId = setupData()

        expect:
        guestService.count() == 5

        when:
        guestService.delete(guestId)
        sessionFactory.currentSession.flush()

        then:
        guestService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Guest guest = new Guest()
        guestService.save(guest)

        then:
        guest.id != null
    }
}
