package com.ligarisma.booking

import grails.gorm.services.Service

@Service(Guest)
interface GuestService {

    Guest get(Serializable id)

    List<Guest> list(Map args)

    Long count()

    void delete(Serializable id)

    Guest save(Guest guest)

}