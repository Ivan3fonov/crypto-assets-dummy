package com.example.informationsystem.feature.home.data.di

import com.example.informationsystem.feature.home.domain.repository.AssetsRepository
import com.example.informationsystem.feature.home.data.repository.AssetsRepositoryImpl
import com.example.informationsystem.feature.home.data.source.AssetsRemoteDataSource
import com.example.informationsystem.feature.home.data.source.AssetsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDataModule {

    @Binds
    abstract fun bindAssetsRemoteDataSource(
        assetsRemoteDataSourceImpl: AssetsRemoteDataSourceImpl
    ): AssetsRemoteDataSource

    @Binds
    abstract fun bindAssetsRepository(
        assetsRepositoryImpl: AssetsRepositoryImpl
    ): AssetsRepository
}