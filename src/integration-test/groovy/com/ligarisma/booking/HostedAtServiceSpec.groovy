package com.ligarisma.booking

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HostedAtServiceSpec extends Specification {

    HostedAtService hostedAtService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HostedAt(...).save(flush: true, failOnError: true)
        //new HostedAt(...).save(flush: true, failOnError: true)
        //HostedAt hostedAt = new HostedAt(...).save(flush: true, failOnError: true)
        //new HostedAt(...).save(flush: true, failOnError: true)
        //new HostedAt(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hostedAt.id
    }

    void "test get"() {
        setupData()

        expect:
        hostedAtService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HostedAt> hostedAtList = hostedAtService.list(max: 2, offset: 2)

        then:
        hostedAtList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        hostedAtService.count() == 5
    }

    void "test delete"() {
        Long hostedAtId = setupData()

        expect:
        hostedAtService.count() == 5

        when:
        hostedAtService.delete(hostedAtId)
        sessionFactory.currentSession.flush()

        then:
        hostedAtService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HostedAt hostedAt = new HostedAt()
        hostedAtService.save(hostedAt)

        then:
        hostedAt.id != null
    }
}
