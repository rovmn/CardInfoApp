package com.example.cardinfoapp.data.remote

import com.example.cardinfoapp.domain.model.Card
import retrofit2.http.GET
import retrofit2.http.Path

interface CardApi {

    @GET("{number}")
    suspend fun getCardByNumber(@Path("number") number: Long): Card

}