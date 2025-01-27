package com.example.cardinfoapp.data.remote

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.EmptyResult
import com.example.cardinfoapp.domain.util.ErrorResult
import com.example.cardinfoapp.domain.util.Result
import com.example.cardinfoapp.domain.util.SuccessResult
import javax.inject.Inject

class CardsRemoteDataSource @Inject constructor(
    private val cardApi: CardApi
) {
    suspend fun getCardInfo(number: Long) : Result<Card> {
        return try {
            val result = cardApi.getCardByNumber(number)
            if(result.scheme != null) SuccessResult(result) else EmptyResult()
        } catch (e: Exception) {
            ErrorResult(e)
        }
    }
}