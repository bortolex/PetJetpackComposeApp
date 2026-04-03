package com.example.petjetpackcomposeapp.draft.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController/*, viewModel: HomeViewModel = hiltViewModel()*/) {
//    val state by viewModel.uiState.collectAsState()

//    when (state) {
/*        is HomeUiState.Loading -> CircularProgressIndicator()
        is HomeUiState.Success -> {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = (state as HomeUiState.Success).data)
                Button(onClick = { viewModel.handleEvent(HomeUiEvent.ButtonClicked) }) {
                    Text("Click Me")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { navController.navigate("details") }) {
                    Text("Go to Details")
                }
            }
        }

        is HomeUiState.Error -> {
            Text("Error: ${(state as HomeUiState.Error).message}")
        }*/
//    }
}
