package com.ligarisma.booking.api

import com.ligarisma.booking.Reservation
import grails.rest.RestfulController

class ReservationController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    ReservationController() {
        super(Reservation)
    }
}
