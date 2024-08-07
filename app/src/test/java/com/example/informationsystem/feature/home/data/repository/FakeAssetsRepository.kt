package com.example.informationsystem.feature.home.data.repository

import com.example.informationsystem.common.result.DataError
import com.example.informationsystem.common.result.Error
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.domain.repository.AssetsRepository
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterNotNull

class FakeAssetsRepository : AssetsRepository {

    private val _assetsData = MutableSharedFlow<Result<Error, List<CryptoAsset>>>(
        replay = 1,
        onBufferOverflow = DROP_OLDEST
    )

    override fun getAssets(): Flow<Result<Error, List<CryptoAsset>>> = _assetsData.filterNotNull()

    fun setAssetsData(assets: List<CryptoAsset>) {
        _assetsData.tryEmit(Result.Success(assets))
    }

    fun setErrorFetchingAssets() {
        _assetsData.tryEmit(Result.Failure(DataError.Network.UNKNOWN))
    }

}