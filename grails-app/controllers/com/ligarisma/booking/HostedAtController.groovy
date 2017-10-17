package com.ligarisma.booking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HostedAtController {

    HostedAtService hostedAtService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond hostedAtService.list(params), model:[hostedAtCount: hostedAtService.count()]
    }

    def show(Long id) {
        respond hostedAtService.get(id)
    }

    def create() {
        respond new HostedAt(params)
    }

    def save(HostedAt hostedAt) {
        if (hostedAt == null) {
            notFound()
            return
        }

        try {
            hostedAtService.save(hostedAt)
        } catch (ValidationException e) {
            respond hostedAt.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hostedAt.label', default: 'HostedAt'), hostedAt.id])
                redirect hostedAt
            }
            '*' { respond hostedAt, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hostedAtService.get(id)
    }

    def update(HostedAt hostedAt) {
        if (hostedAt == null) {
            notFound()
            return
        }

        try {
            hostedAtService.save(hostedAt)
        } catch (ValidationException e) {
            respond hostedAt.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hostedAt.label', default: 'HostedAt'), hostedAt.id])
                redirect hostedAt
            }
            '*'{ respond hostedAt, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hostedAtService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hostedAt.label', default: 'HostedAt'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hostedAt.label', default: 'HostedAt'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
