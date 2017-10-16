package com.ligarisma.booking

class HostedAt {


    static belongsTo = [guest: Guest, occupiedRoom: OccupiedRoom]

    static constraints = {
    }
}
