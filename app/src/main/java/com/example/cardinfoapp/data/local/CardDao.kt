package com.example.cardinfoapp.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cardinfoapp.data.local.entity.CardDbEntity

@Dao
interface CardDao {

    @Upsert
    suspend fun saveCard(card: CardDbEntity)

    @Query("SELECT * FROM cards")
    suspend fun getCards(): List<CardDbEntity>

}