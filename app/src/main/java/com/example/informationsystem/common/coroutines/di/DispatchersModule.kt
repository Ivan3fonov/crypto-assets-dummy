package com.example.informationsystem.common.coroutines.di

import com.example.informationsystem.common.coroutines.dispatchers.AppDispatchers.IO
import com.example.informationsystem.common.coroutines.dispatchers.AppDispatchers.Default
import com.example.informationsystem.common.coroutines.dispatchers.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
