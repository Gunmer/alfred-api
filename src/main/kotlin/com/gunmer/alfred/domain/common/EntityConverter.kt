package com.gunmer.alfred.domain.common

interface EntityConverter<E, P> {
    fun convertFrom(entity: E): P
    fun P.convertTo(): E
}
