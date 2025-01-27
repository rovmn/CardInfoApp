package com.example.cardinfoapp.presentation.util

sealed class MainEvent {
    object SearchClicked : MainEvent()
    data class CardNumberChanged(val value: String): MainEvent()
}