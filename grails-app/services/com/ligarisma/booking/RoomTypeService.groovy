package com.ligarisma.booking

import grails.gorm.services.Service

@Service(RoomType)
interface RoomTypeService {

    RoomType get(Serializable id)

    List<RoomType> list(Map args)

    Long count()

    void delete(Serializable id)

    RoomType save(RoomType roomType)

}