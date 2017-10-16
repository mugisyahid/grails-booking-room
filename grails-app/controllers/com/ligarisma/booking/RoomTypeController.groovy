package com.ligarisma.booking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RoomTypeController {

    RoomTypeService roomTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond roomTypeService.list(params), model:[roomTypeCount: roomTypeService.count()]
    }

    def show(Long id) {
        respond roomTypeService.get(id)
    }

    def create() {
        respond new RoomType(params)
    }

    def save(RoomType roomType) {
        if (roomType == null) {
            notFound()
            return
        }

        try {
            roomTypeService.save(roomType)
        } catch (ValidationException e) {
            respond roomType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roomType.label', default: 'RoomType'), roomType.id])
                redirect roomType
            }
            '*' { respond roomType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond roomTypeService.get(id)
    }

    def update(RoomType roomType) {
        if (roomType == null) {
            notFound()
            return
        }

        try {
            roomTypeService.save(roomType)
        } catch (ValidationException e) {
            respond roomType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'roomType.label', default: 'RoomType'), roomType.id])
                redirect roomType
            }
            '*'{ respond roomType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        roomTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'roomType.label', default: 'RoomType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roomType.label', default: 'RoomType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
