package com.example.cardinfoapp.domain.repository

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.Result

interface CardRepository {

    suspend fun getCardInfo(cardNumber: Long): Result<Card>

    suspend fun getSearchHistory(): Result<List<Card>>
}