package com.example.informationsystem.feature.home.domain.repository

import com.example.informationsystem.common.result.Error
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import kotlinx.coroutines.flow.Flow

interface AssetsRepository {

    fun getAssets(): Flow<Result<Error, List<CryptoAsset>>>
}