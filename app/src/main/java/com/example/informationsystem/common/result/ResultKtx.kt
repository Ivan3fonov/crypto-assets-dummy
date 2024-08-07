package com.example.informationsystem.common.result

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

inline fun <E : Error, D, R> Flow<Result<E, D>>.mapState(crossinline transform: (D) -> R): Flow<Result<E, R>> =
    map { result ->
        when (result) {
            is Result.Success -> Result.Success(transform(result.data))
            is Result.Failure -> result
        }
    }

inline fun <E : Error, D> Flow<Result<E, D>>.onSuccess(crossinline action: (D) -> Unit): Flow<Result<E, D>> =
    onEach { result ->
        if (result is Result.Success) action(result.data)
    }

inline fun <E : Error, D> Flow<Result<E, D>>.onError(crossinline action: (E) -> Unit): Flow<Result<E, D>> =
    onEach { result ->
        if ( result is Result.Failure) action(result.error)
    }

inline fun <T> asApiResult(
    dispatcher: CoroutineDispatcher,
    crossinline request: suspend () -> T
): Flow<Result<DataError.Network, T>> = flow<Result<DataError.Network, T>> {
    val data = request()
    emit(Result.Success(data))

}.catch { e ->
    Log.e("Crash",e.toString())
    emit(Result.Failure(DataError.Network.UNKNOWN))
}
    .flowOn(dispatcher)
