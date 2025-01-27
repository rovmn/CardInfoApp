package com.example.cardinfoapp.di

import android.content.Context
import androidx.room.Room
import com.example.cardinfoapp.data.local.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): AppDB{
        return Room.databaseBuilder(
            context,
            AppDB::class.java,
            "database.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCardDao(db: AppDB) = db.getCardDao()
}