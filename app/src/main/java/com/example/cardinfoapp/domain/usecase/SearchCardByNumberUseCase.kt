package com.example.cardinfoapp.domain.usecase

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.repository.CardRepository
import com.example.cardinfoapp.domain.util.Result
import javax.inject.Inject

class SearchCardByNumberUseCase @Inject constructor(
    private val repository: CardRepository
) {
    suspend fun getCardInfo(number: Long): Result<Card> = repository.getCardInfo(number)
}