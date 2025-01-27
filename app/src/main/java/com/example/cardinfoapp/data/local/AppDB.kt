package com.example.cardinfoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cardinfoapp.data.local.entity.CardDbEntity

@Database(
    version = 1,
    entities = [
        CardDbEntity::class
    ]
)
abstract class AppDB : RoomDatabase() {
    abstract fun getCardDao(): CardDao
}