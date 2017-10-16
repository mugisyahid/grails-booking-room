package com.ligarisma.booking

class ReservedRoom {


    Integer numberOfRooms

    String status // enum later



    static belongsTo = [reservation: Reservation, roomType: RoomType]

    static constraints = {
    }
}
