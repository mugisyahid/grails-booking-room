package com.ligarisma.booking.api

import com.ligarisma.booking.HostedAt
import grails.rest.RestfulController

class HostedAtController extends RestfulController {

    static namespace = 'api'

    static responseFormats = ['json']

    HostedAtController() {
        super(HostedAt)
    }
}
