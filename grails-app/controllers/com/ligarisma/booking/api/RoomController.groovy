package com.ligarisma.booking.api

import com.ligarisma.booking.Room
import grails.rest.RestfulController

class RoomController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    RoomController() {
        super(Room)
    }
}
