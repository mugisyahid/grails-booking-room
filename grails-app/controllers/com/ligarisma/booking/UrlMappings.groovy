package com.ligarisma.booking

class UrlMappings {

    static mappings = {
//        delete "/$controller/$id(.$format)?"(action:"delete")
//        get "/$controller(.$format)?"(action:"index")
//        get "/$controller/$id(.$format)?"(action:"show")
//        post "/$controller(.$format)?"(action:"save")
//        put "/$controller/$id(.$format)?"(action:"update")
//        patch "/$controller/$id(.$format)?"(action:"patch")

        "500"(view: '/error')
        "404"(view: '/notFound')

        "/"(controller: 'application', action:'index')

        group('/api'){

            '/guests'(resources: 'guest', namespace: 'api')
            '/hostedat'(resources: 'hostedat', namespace: 'api')
            '/occupied'(resources: 'occupiedroom', namespace: 'api')
            '/reservation'(resources: 'reservation', namespace: 'api')
            '/reservedroom'(resources: 'reservedroom', namespace: 'api')
            '/room'(resources: 'room', namespace: 'api')
            '/roomtype'(resources: 'roomtype', namespace: 'api')

        }


    }
}
