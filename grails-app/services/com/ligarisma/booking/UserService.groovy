package com.ligarisma.booking

import grails.plugin.springsecurity.SpringSecurityService

class UserService {

    SpringSecurityService springSecurityService

    void setPassword(User user, String password) {
        user.password = springSecurityService.encodePassword(password)
    }
}
