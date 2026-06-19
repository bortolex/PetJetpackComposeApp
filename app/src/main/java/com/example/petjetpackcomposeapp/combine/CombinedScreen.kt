package com.example.petjetpackcomposeapp.combine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CombinedScreen(viewModel: CombinedViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    when (val s = state) {
        CombinedState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }

        is CombinedState.Success -> Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text("User: ${s.data.userName}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Orders:", fontWeight = FontWeight.SemiBold)
            s.data.orders.forEach { Text("• $it") }
            Text("Settings:", fontWeight = FontWeight.SemiBold)
            s.data.settings.forEach { (k, v) -> Text("• $k: $v") }
        }
    }
}
