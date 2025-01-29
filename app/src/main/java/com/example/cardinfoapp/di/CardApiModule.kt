package com.example.cardinfoapp.di

import com.example.cardinfoapp.data.remote.CardApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardApiModule {
    private val baseUrl = "https://lookup.binlist.net/"

    @Provides
    @Singleton
    fun provideCardApi(
        gson: Gson,
        client: OkHttpClient
    ): CardApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(CardApi::class.java)
    }

    @Provides
    @Singleton
    fun provideJsonConverter(): Gson = GsonBuilder()
        .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{

        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}