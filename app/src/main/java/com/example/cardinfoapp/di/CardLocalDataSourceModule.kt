package com.example.cardinfoapp.di

import com.example.cardinfoapp.data.local.CardDao
import com.example.cardinfoapp.data.local.CardsLocalDataSource
import com.example.cardinfoapp.data.util.CardDbEntityToCardMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardLocalDataSourceModule {

    @Provides
    @Singleton
    fun provideCardLocalDataSource(
        cardDao: CardDao,
        cardDbEntityToCardMapper: CardDbEntityToCardMapper
    ): CardsLocalDataSource {
        return CardsLocalDataSource(cardDao, cardDbEntityToCardMapper)
    }
}