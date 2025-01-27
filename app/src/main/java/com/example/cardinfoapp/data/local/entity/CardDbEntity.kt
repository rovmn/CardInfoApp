package com.example.cardinfoapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cardinfoapp.domain.model.Bank
import com.example.cardinfoapp.domain.model.Country
import com.example.cardinfoapp.domain.model.Number

@Entity(tableName = "cards")
data class CardDbEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @Embedded(prefix = "number_")
    val number: Number,

    val scheme: String?,

    val type: String?,

    val brand: String?,

    val prepaid: Boolean?,

    @Embedded(prefix = "country_")
    val country: Country,

    @Embedded(prefix = "bank_")
    val bank: Bank
)
