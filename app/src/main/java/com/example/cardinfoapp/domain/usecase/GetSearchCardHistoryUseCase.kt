package com.example.cardinfoapp.domain.usecase

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.repository.CardRepository
import com.example.cardinfoapp.domain.util.Result
import javax.inject.Inject

class GetSearchHistoryUseCase @Inject constructor(
    private val repository: CardRepository
) {
    suspend fun getSearchHistory(): Result<List<Card>> = repository.getSearchHistory()
}