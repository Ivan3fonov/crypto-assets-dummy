package com.example.informationsystem.core_network.di

import com.example.informationsystem.core_network.client.KtorHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideKtorHttpClient(
    ): HttpClient {
        return KtorHttpClient().get()
    }
}