package com.example.informationsystem.feature.home.data.source

import com.example.informationsystem.common.result.DataError
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.feature.home.data.model.CryptoAssetDto
import kotlinx.coroutines.flow.Flow

interface AssetsRemoteDataSource {

   fun getCryptoAssets(): Flow<Result<DataError.Network, List<CryptoAssetDto>>>
}