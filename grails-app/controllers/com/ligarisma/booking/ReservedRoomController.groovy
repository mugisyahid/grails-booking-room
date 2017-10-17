package com.ligarisma.booking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReservedRoomController {

    ReservedRoomService reservedRoomService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reservedRoomService.list(params), model:[reservedRoomCount: reservedRoomService.count()]
    }

    def show(Long id) {
        respond reservedRoomService.get(id)
    }

    def create() {
        respond new ReservedRoom(params)
    }

    def save(ReservedRoom reservedRoom) {
        if (reservedRoom == null) {
            notFound()
            return
        }

        try {
            reservedRoomService.save(reservedRoom)
        } catch (ValidationException e) {
            respond reservedRoom.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reservedRoom.label', default: 'ReservedRoom'), reservedRoom.id])
                redirect reservedRoom
            }
            '*' { respond reservedRoom, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reservedRoomService.get(id)
    }

    def update(ReservedRoom reservedRoom) {
        if (reservedRoom == null) {
            notFound()
            return
        }

        try {
            reservedRoomService.save(reservedRoom)
        } catch (ValidationException e) {
            respond reservedRoom.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reservedRoom.label', default: 'ReservedRoom'), reservedRoom.id])
                redirect reservedRoom
            }
            '*'{ respond reservedRoom, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reservedRoomService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reservedRoom.label', default: 'ReservedRoom'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservedRoom.label', default: 'ReservedRoom'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
