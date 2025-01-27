package com.example.cardinfoapp.di

import com.example.cardinfoapp.data.util.CardDbEntityToCardMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardDbEntityToCardMapperModule {

    @Provides
    @Singleton
    fun provideCardDbEntityToCardMapper(): CardDbEntityToCardMapper{
        return CardDbEntityToCardMapper()
    }
}