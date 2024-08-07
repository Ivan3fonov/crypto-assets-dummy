package com.example.informationsystem.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.informationsystem.common.result.onError
import com.example.informationsystem.common.result.onSuccess
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.domain.usecase.GetCryptoAssetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Content(
        val assets: List<CryptoAsset> = emptyList(),
        val error: String? = null,
    ) : HomeUiState
}

@HiltViewModel
class HomeViewModel
@Inject constructor(private val getCryptoAssetsUseCase: GetCryptoAssetsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getAssets() {
        getCryptoAssetsUseCase()
            .onSuccess { assets ->
                _uiState.update { _->
                    HomeUiState.Content(
                        assets = assets
                    )
                }
            }
            .onError {
                _uiState.update { _ ->
                    HomeUiState.Content(
                        error = "Something went wrong"
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun errorShown() {
        _uiState.update { _ ->
            HomeUiState.Content(
                error = null
            )
        }
    }
}