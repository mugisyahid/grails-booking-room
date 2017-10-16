package com.ligarisma.booking

class Room {

    Integer number

    String name

    String status

    boolean smoke

    static belongsTo = [roomType: RoomType]


    static constraints = {
    }
}
