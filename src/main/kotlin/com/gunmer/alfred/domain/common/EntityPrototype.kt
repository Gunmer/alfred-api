package com.gunmer.alfred.domain.common

interface EntityPrototype<E, P> {
    fun cloneToPrototype(entity: E): P
    fun P.cloneFromPrototype(): E
}
