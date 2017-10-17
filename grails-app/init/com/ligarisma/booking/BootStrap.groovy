package com.ligarisma.booking

class BootStrap {



    UserService userService

    def init = { servletContext ->

        def userRole = Authority.findOrSaveByAuthority('ROLE_USER')
        def adminRole = Authority.findOrSaveByAuthority('ROLE_ADMIN')

        def user = new User(username: 'user' ,password: '123')
        userService.setPassword(user, '123')
        user.save(flush:true)
        def admin = new User(username: 'admin' ,password: '1234')
        userService.setPassword(admin, '1234')
        admin.save(flush:true)
//        UserAuthority.create(user, userRole)
//        UserAuthority.create(admin, adminRole)

        UserAuthority userAuthority =  new UserAuthority()
        userAuthority.setUser(user)
        userAuthority.setAuthority(userRole)
//        userAuthority.save(flush:true)

        User.withSession { it.flush() }

    }
    def destroy = {
    }
}
