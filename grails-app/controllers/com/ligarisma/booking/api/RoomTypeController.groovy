package com.ligarisma.booking.api

import com.ligarisma.booking.RoomType
import grails.rest.RestfulController

class RoomTypeController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    RoomTypeController() {
        super(RoomType)
    }
}
