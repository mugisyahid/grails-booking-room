package com.ligarisma.booking

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString

import java.time.LocalDateTime

@GrailsCompileStatic
@ToString(includeNames = true, includePackage = false)
class Reservation {

    LocalDateTime dateIn

    LocalDateTime dateOut

    String madeBy //later as enum, online, etc

    static belongsTo = [guest: Guest]


    static constraints = {
    }
}
