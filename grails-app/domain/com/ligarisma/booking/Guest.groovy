package com.ligarisma.booking

import java.time.LocalDateTime

class Guest {


    String firstName

    String lastName

    LocalDateTime memberSince

    //user to login credential

    static constraints = {
        memberSince  nullable: true
    }
}
