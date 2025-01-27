package com.example.cardinfoapp.di

import com.example.cardinfoapp.data.remote.CardApi
import com.example.cardinfoapp.data.remote.CardsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardRemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideCardRemoteDataSource(
        cardApi: CardApi
    ): CardsRemoteDataSource {
        return CardsRemoteDataSource(cardApi)
    }
}