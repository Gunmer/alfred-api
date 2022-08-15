package com.gunmer.alfred.domain.common

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

sealed class DomainExceptions {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class EntityNotFound(entityName: String,  entityId: String) : RuntimeException("The $entityName with id $entityId not found")
    @ResponseStatus(HttpStatus.CONFLICT)
    class InvalidState(message: String) : RuntimeException(message)
}
