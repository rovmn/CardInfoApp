package com.example.cardinfoapp.domain.model

data class Card(
    val number: Number,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: Country,
    val bank: Bank,
)
