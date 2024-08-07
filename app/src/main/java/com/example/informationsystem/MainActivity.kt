package com.example.informationsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.informationsystem.feature.home.presentation.navigation.Home
import com.example.informationsystem.feature.home.presentation.navigation.HomeDetails
import com.example.informationsystem.feature.home.presentation.navigation.homeDetailsScreen
import com.example.informationsystem.feature.home.presentation.navigation.homeScreen
import com.example.informationsystem.feature.home.presentation.ui.HomeScreen
import com.example.informationsystem.ui.theme.InformationSystemTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }
            val mainScope = rememberCoroutineScope()

            InformationSystemTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Home
                    ) {
                        homeScreen(
                            onNavigateToDetails = { asset ->
                                navController.navigate(
                                    HomeDetails(
                                        symbol = asset.symbol,
                                        askPrice = asset.askPrice.toString(),
                                        bidPrice = asset.bidPrice.toString()
                                    )
                                )
                            },
                            onShowSnackbar = {
                                mainScope.launch { snackbarHostState.showSnackbar(it) }
                            }
                        )

                        homeDetailsScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onShowSnackbar = {
                                mainScope.launch { snackbarHostState.showSnackbar(it) }
                            })
                    }
                }
            }
        }
    }
}

