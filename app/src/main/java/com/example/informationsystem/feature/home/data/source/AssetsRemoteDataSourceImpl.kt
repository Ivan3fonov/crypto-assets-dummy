package com.example.informationsystem.feature.home.data.source

import com.example.informationsystem.common.coroutines.dispatchers.AppDispatchers.IO
import com.example.informationsystem.common.coroutines.dispatchers.Dispatcher
import com.example.informationsystem.common.result.DataError
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.common.result.asApiResult
import com.example.informationsystem.feature.home.data.model.CryptoAssetDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AssetsRemoteDataSourceImpl
@Inject constructor(
    private val httpClient: HttpClient,
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher
) : AssetsRemoteDataSource {

    override fun getCryptoAssets(): Flow<Result<DataError.Network, List<CryptoAssetDto>>> =
        asApiResult(ioDispatcher) {
            httpClient.get("ticker/24hr").body<List<CryptoAssetDto>>()
        }
}
