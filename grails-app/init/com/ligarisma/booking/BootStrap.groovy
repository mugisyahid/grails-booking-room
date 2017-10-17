package com.ligarisma.booking

class BootStrap {

    def init = { servletContext ->

        def userRole = Authority.findOrSaveByAuthority('ROLE_USER')
        def adminRole = Authority.findOrSaveByAuthority('ROLE_ADMIN')

        def user = new User(username: 'user' ,password: '123').save()
        def admin = new User(username: 'admin' ,password: '1234').save()
//        UserAuthority.create(user, userRole)
//        UserAuthority.create(admin, adminRole)

        User.withSession { it.flush() }

    }
    def destroy = {
    }
}
