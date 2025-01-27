package com.example.cardinfoapp.di

import com.example.cardinfoapp.data.repository.CardRepositoryImpl
import com.example.cardinfoapp.domain.repository.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CardRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCardRepository(
        cardRepositoryImpl: CardRepositoryImpl
    ): CardRepository

}