package com.example.cardinfoapp.data.local

import com.example.cardinfoapp.data.util.CardDbEntityToCardMapper
import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.EmptyResult
import com.example.cardinfoapp.domain.util.ErrorResult
import com.example.cardinfoapp.domain.util.Result
import com.example.cardinfoapp.domain.util.SuccessResult
import javax.inject.Inject

class CardsLocalDataSource @Inject constructor(
    private val cardDao: CardDao,
    private val cardDbEntityToCardMapper: CardDbEntityToCardMapper
) {

    suspend fun getCards() : Result<List<Card>> {
        return try {
            val result = cardDbEntityToCardMapper.map(cardDao.getCards())
            if(result.isNotEmpty()) SuccessResult(result) else EmptyResult()
        } catch (e: Exception) {
            ErrorResult(e)
        }
    }

    suspend fun saveCard(card: Card): Result<Unit> {
        return try {
            cardDao.saveCard(cardDbEntityToCardMapper.reverseMap(card))
            SuccessResult(Unit)
        } catch (e: Exception){
            ErrorResult(e)
        }
    }
}