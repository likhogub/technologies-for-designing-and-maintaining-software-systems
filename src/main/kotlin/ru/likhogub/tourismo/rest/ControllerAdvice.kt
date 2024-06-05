package ru.likhogub.tourismo.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ControllerAdvice {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun conflict(e: Exception): ApplicationError {
        return ApplicationError(e.message)
    }

    data class ApplicationError(val code: String?)
}