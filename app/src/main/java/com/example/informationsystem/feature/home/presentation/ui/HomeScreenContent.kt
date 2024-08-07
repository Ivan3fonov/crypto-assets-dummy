package com.example.informationsystem.feature.home.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.presentation.viewmodel.HomeUiState

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onShowSnackbar: (String) -> Unit,
    onErrorShown: () -> Unit,
    onNavigateToDetails: (CryptoAsset) -> Unit
) {

    Column(modifier = modifier.fillMaxSize()) {
        when (uiState) {
            HomeUiState.Loading ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            is HomeUiState.Content -> {

                uiState.error?.let { error ->
                    LaunchedEffect(error) {
                        onShowSnackbar(error)
                        onErrorShown()
                    }
                }

                if (uiState.assets.isNotEmpty()) {

                    AssetsList(
                        modifier = Modifier.fillMaxSize(),
                        assets = uiState.assets,
                        onAssetClicked = onNavigateToDetails
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AssetsList(
    modifier: Modifier = Modifier,
    assets: List<CryptoAsset>,
    onAssetClicked: (CryptoAsset) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        stickyHeader {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                text = "Crypto Assets"
            )

            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }

        items(assets) { item ->

            AssetItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                asset = item, onAssetClicked = onAssetClicked
            )

            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 32.sp
    )
}

@Composable
private fun AssetItem(
    modifier: Modifier = Modifier,
    asset: CryptoAsset,
    onAssetClicked: (CryptoAsset) -> Unit,
) {
    Row(
        modifier = modifier
            .clickable(onClick = { onAssetClicked(asset)})
            .padding(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = asset.symbol)
        Text(text = "${asset.lastPrice} BTC")
    }
}