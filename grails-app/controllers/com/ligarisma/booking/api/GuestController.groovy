package com.ligarisma.booking.api

import com.ligarisma.booking.Guest
import grails.rest.RestfulController

class GuestController extends RestfulController {

    static responseFormats = ['json']

    GuestController() {
        super(Guest)
    }
}
