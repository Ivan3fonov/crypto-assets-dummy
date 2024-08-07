package com.example.informationsystem.common.result

sealed interface Result<out E: Error, out D> {
    data class Failure<out E : Error>(val error: E) : Result<E, Nothing>
    data class Success<out D>(val data: D) : Result<Nothing, D>
}
