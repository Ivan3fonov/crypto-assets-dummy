package com.example.informationsystem.feature.home.presentation.viewmodel

import android.service.autofill.UserData
import com.example.informationsystem.common.result.DataError
import com.example.informationsystem.common.result.Error
import com.example.informationsystem.common.result.Result
import com.example.informationsystem.feature.home.data.repository.FakeAssetsRepository
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.domain.repository.AssetsRepository
import com.example.informationsystem.feature.home.domain.usecase.GetCryptoAssetsUseCase
import com.example.informationsystem.rules.MainDispatcherRule
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.math.BigDecimal

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: HomeViewModel

    private val fakeAssetsRepository = FakeAssetsRepository()
    private val getCryptoAssetsUseCase = GetCryptoAssetsUseCase(fakeAssetsRepository)

    @Before
    fun setup() {
        viewModel = HomeViewModel(getCryptoAssetsUseCase)
    }

    @Test
    fun testInitialStateIsLoading() = runTest {
        assertEquals(HomeUiState.Loading, viewModel.uiState.value)
    }

    @Test
    fun testErrorShown() = runTest {

        viewModel.getAssets()

        fakeAssetsRepository.setErrorFetchingAssets()

        assertEquals(HomeUiState.Content(error = "Something went wrong"), viewModel.uiState.value)
    }

    @Test
    fun testAssetsShown() = runTest {

        viewModel.getAssets()

        fakeAssetsRepository.setAssetsData(assets = listOf(testCryptoAsset))

        assertEquals(HomeUiState.Content(assets = listOf(testCryptoAsset)), viewModel.uiState.value)
    }

    private val testCryptoAsset = CryptoAsset(
        symbol = "ETHBTC",
        priceChange = BigDecimal("-0.00057000"),
        priceChangePercent = BigDecimal("-1.066"),
        weightedAvgPrice = BigDecimal("0.05289369"),
        prevClosePrice = BigDecimal("0.05345000"),
        lastPrice = BigDecimal("0.05289000"),
        lastQty = BigDecimal("0.02460000"),
        bidPrice = BigDecimal("0.05288000"),
        bidQty = BigDecimal("13.65000000"),
        askPrice = BigDecimal("0.05289000"),
        askQty = BigDecimal("24.07940000"),
        openPrice = BigDecimal("0.05346000"),
        highPrice = BigDecimal("0.05351000"),
        lowPrice = BigDecimal("0.05249000"),
        volume = BigDecimal("24746.19490000"),
        quoteVolume = BigDecimal("1308.91753604"),
        openTime = 1720186060105,
        closeTime = 1720272460105,
        firstId = 453318440,
        lastId = 453523980,
        count = 205541
    )
}
