package com.ligarisma.booking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OccupiedRoomController {

    OccupiedRoomService occupiedRoomService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond occupiedRoomService.list(params), model:[occupiedRoomCount: occupiedRoomService.count()]
    }

    def show(Long id) {
        respond occupiedRoomService.get(id)
    }

    def create() {
        respond new OccupiedRoom(params)
    }

    def save(OccupiedRoom occupiedRoom) {
        if (occupiedRoom == null) {
            notFound()
            return
        }

        try {
            occupiedRoomService.save(occupiedRoom)
        } catch (ValidationException e) {
            respond occupiedRoom.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'occupiedRoom.label', default: 'OccupiedRoom'), occupiedRoom.id])
                redirect occupiedRoom
            }
            '*' { respond occupiedRoom, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond occupiedRoomService.get(id)
    }

    def update(OccupiedRoom occupiedRoom) {
        if (occupiedRoom == null) {
            notFound()
            return
        }

        try {
            occupiedRoomService.save(occupiedRoom)
        } catch (ValidationException e) {
            respond occupiedRoom.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'occupiedRoom.label', default: 'OccupiedRoom'), occupiedRoom.id])
                redirect occupiedRoom
            }
            '*'{ respond occupiedRoom, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        occupiedRoomService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'occupiedRoom.label', default: 'OccupiedRoom'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'occupiedRoom.label', default: 'OccupiedRoom'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
