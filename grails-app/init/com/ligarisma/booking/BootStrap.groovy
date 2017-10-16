package com.ligarisma.booking

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j


@Slf4j
@Transactional
class BootStrap {

    def init = { servletContext ->
        Guest guest = new Guest(firstName: "ligar", lastName: "mugi syahid", memberSince: new Date())
        log.info 'init data'
        guest.save()
    }
    def destroy = {
    }
}
