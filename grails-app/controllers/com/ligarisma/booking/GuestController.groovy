package com.ligarisma.booking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GuestController {

    GuestService guestService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond guestService.list(params), model:[guestCount: guestService.count()]
    }

    def show(Long id) {
        respond guestService.get(id)
    }

    def create() {
        respond new Guest(params)
    }

    def save(Guest guest) {
        if (guest == null) {
            notFound()
            return
        }

        try {
            guestService.save(guest)
        } catch (ValidationException e) {
            respond guest.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'guest.label', default: 'Guest'), guest.id])
                redirect guest
            }
            '*' { respond guest, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond guestService.get(id)
    }

    def update(Guest guest) {
        if (guest == null) {
            notFound()
            return
        }

        try {
            guestService.save(guest)
        } catch (ValidationException e) {
            respond guest.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'guest.label', default: 'Guest'), guest.id])
                redirect guest
            }
            '*'{ respond guest, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        guestService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'guest.label', default: 'Guest'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'guest.label', default: 'Guest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
