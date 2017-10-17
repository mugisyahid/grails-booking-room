package com.ligarisma.booking

import grails.gorm.services.Service

@Service(ReservedRoom)
interface ReservedRoomService {

    ReservedRoom get(Serializable id)

    List<ReservedRoom> list(Map args)

    Long count()

    void delete(Serializable id)

    ReservedRoom save(ReservedRoom reservedRoom)

}