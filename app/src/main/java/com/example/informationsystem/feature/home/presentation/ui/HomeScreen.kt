package com.example.informationsystem.feature.home.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    onNavigateToDetails: (CryptoAsset) -> Unit,
    onShowSnackbar: (String) -> Unit,
    viewModel: HomeViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getAssets()
    }

    HomeScreenContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onShowSnackbar = onShowSnackbar,
        onErrorShown = viewModel::errorShown,
        onNavigateToDetails = onNavigateToDetails
    )

}