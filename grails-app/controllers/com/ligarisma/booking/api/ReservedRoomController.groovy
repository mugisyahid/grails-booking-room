package com.ligarisma.booking.api

import com.ligarisma.booking.ReservedRoom
import grails.rest.RestfulController

class ReservedRoomController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    ReservedRoomController() {
        super(ReservedRoom)
    }

}
