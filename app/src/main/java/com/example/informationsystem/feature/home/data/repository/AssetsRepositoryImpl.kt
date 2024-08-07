package com.example.informationsystem.feature.home.data.repository

import com.example.informationsystem.common.result.Error
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.common.result.mapState
import com.example.informationsystem.feature.home.data.model.CryptoAssetDto
import com.example.informationsystem.feature.home.data.source.AssetsRemoteDataSource
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.domain.repository.AssetsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AssetsRepositoryImpl
@Inject constructor(private val remoteDataSource: AssetsRemoteDataSource): AssetsRepository {
    override fun getAssets(): Flow<Result<Error, List<CryptoAsset>>>   =
        remoteDataSource.getCryptoAssets().mapState {
            it.map { asset -> asset.toCryptoAsset() }
        }
}

fun CryptoAssetDto.toCryptoAsset(): CryptoAsset {
    return CryptoAsset(
        symbol = this.symbol,
        priceChange = this.priceChange,
        priceChangePercent = this.priceChangePercent,
        weightedAvgPrice = this.weightedAvgPrice,
        prevClosePrice = this.prevClosePrice,
        lastPrice = this.lastPrice,
        lastQty = this.lastQty,
        bidPrice = this.bidPrice,
        bidQty = this.bidQty,
        askPrice = this.askPrice,
        askQty = this.askQty,
        openPrice = this.openPrice,
        highPrice = this.highPrice,
        lowPrice = this.lowPrice,
        volume = this.volume,
        quoteVolume = this.quoteVolume,
        openTime = this.openTime,
        closeTime = this.closeTime,
        firstId = this.firstId,
        lastId = this.lastId,
        count = this.count
    )
}
