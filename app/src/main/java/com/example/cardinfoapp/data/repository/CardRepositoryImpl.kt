package com.example.cardinfoapp.data.repository

import com.example.cardinfoapp.data.local.CardsLocalDataSource
import com.example.cardinfoapp.data.remote.CardsRemoteDataSource
import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.repository.CardRepository
import com.example.cardinfoapp.domain.util.Result
import com.example.cardinfoapp.domain.util.SuccessResult
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardsRemoteDataSource: CardsRemoteDataSource,
    private val cardsLocalDataSource: CardsLocalDataSource
) : CardRepository {

    override suspend fun getCardInfo(cardNumber: Long): Result<Card> =
        cardsRemoteDataSource.getCardInfo(cardNumber).also {
            if(it is SuccessResult) cardsLocalDataSource.saveCard(it.data)
        }

    override suspend fun getSearchHistory(): Result<List<Card>> = cardsLocalDataSource.getCards()
}