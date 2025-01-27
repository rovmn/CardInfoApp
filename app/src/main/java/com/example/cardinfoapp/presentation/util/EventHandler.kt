package com.example.cardinfoapp.presentation.util

interface EventHandler<E> {
    fun obtainEvent(event: E)
}