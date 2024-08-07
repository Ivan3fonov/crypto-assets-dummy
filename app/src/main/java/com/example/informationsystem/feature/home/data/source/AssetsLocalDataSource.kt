package com.example.informationsystem.feature.home.data.source

import com.example.informationsystem.common.result.DataError
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.feature.home.data.model.CryptoAssetEntity
import kotlinx.coroutines.flow.Flow

interface AssetsLocalDataSource {

    suspend fun getCryptoAssets(): Flow<Result<DataError.Local, List<CryptoAssetEntity>>>
}