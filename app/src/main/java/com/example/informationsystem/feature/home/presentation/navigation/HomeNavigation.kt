package com.example.informationsystem.feature.home.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.informationsystem.feature.home.domain.model.CryptoAsset
import com.example.informationsystem.feature.home.presentation.ui.HomeDetailsScreen
import com.example.informationsystem.feature.home.presentation.ui.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class HomeDetails(
    val symbol: String,
    val askPrice: String,
    val bidPrice: String
)

fun NavGraphBuilder.homeScreen(
    onNavigateToDetails: (CryptoAsset) -> Unit,
    onShowSnackbar: (String) -> Unit,
) {
    composable<Home> {
        HomeScreen(
            onNavigateToDetails = onNavigateToDetails,
            onShowSnackbar = onShowSnackbar,
            viewModel = hiltViewModel()
        )
    }
}

fun NavGraphBuilder.homeDetailsScreen(
    onNavigateBack: () -> Unit,
    onShowSnackbar: (String) -> Unit,
) {
    composable<HomeDetails> { backStackEntry ->

        val homeDetails: HomeDetails = backStackEntry.toRoute()

        HomeDetailsScreen(
            details = homeDetails,
            onNavigateBack = onNavigateBack,
            onShowSnackbar = onShowSnackbar
        )
    }
}
