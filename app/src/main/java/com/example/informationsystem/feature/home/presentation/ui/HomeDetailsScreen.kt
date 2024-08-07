package com.example.informationsystem.feature.home.presentation.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import com.example.informationsystem.feature.home.presentation.navigation.HomeDetails

@Composable
fun HomeDetailsScreen(
    details: HomeDetails,
    onNavigateBack: () -> Unit,
    onShowSnackbar: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = details.symbol,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "${details.askPrice} BTC")
            Text(text = "${details.askPrice} BTC")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier.weight(1f),
                interactionSource = remember { MutableInteractionSource() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = { onShowSnackbar("TODO implement buy") }) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Buy",
                    textAlign = TextAlign.Center
                )
            }
            Button(
                modifier = Modifier.weight(1f),
                interactionSource = remember { MutableInteractionSource() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                onClick = { onShowSnackbar("TODO implement sell") }) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Sell",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}