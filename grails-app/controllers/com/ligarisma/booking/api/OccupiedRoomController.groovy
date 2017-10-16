package com.ligarisma.booking.api

import com.ligarisma.booking.OccupiedRoom
import grails.rest.RestfulController

class OccupiedRoomController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    OccupiedRoomController() {
        super(OccupiedRoom)
    }
}
