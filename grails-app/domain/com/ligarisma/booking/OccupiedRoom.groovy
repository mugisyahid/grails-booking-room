package com.ligarisma.booking

import java.time.LocalDateTime

class OccupiedRoom {

    LocalDateTime checkIn

    LocalDateTime checkOut


    static belongsTo = [reservation: Reservation, room: Room]


    static constraints = {
    }
}
