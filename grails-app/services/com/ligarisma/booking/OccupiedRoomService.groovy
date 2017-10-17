package com.ligarisma.booking

import grails.gorm.services.Service

@Service(OccupiedRoom)
interface OccupiedRoomService {

    OccupiedRoom get(Serializable id)

    List<OccupiedRoom> list(Map args)

    Long count()

    void delete(Serializable id)

    OccupiedRoom save(OccupiedRoom occupiedRoom)

}