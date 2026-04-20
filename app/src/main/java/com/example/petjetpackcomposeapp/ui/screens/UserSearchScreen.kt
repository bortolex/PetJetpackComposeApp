package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.petjetpackcomposeapp.presentation.SearchUiState
import com.example.petjetpackcomposeapp.presentation.StateFlowViewModel

@Composable
fun UserSearchScreen() {
    val viewModel: StateFlowViewModel = hiltViewModel()
    val resultState = viewModel.searchResultState.collectAsStateWithLifecycle()

    val onQueryChanged: (String) -> Unit = { userQuery ->
        viewModel.onQueryChanged(query = userQuery)
    }

    when (resultState.value) {
        is SearchUiState.Initial -> {
            InitialView(onQueryChanged = onQueryChanged)
        }
        is SearchUiState.Success -> {
            SearchResultsListView(
                list = (resultState.value as SearchUiState.Success).data,
                onQueryChanged = onQueryChanged
            )
        }
        is SearchUiState.Loading -> {
            LoadingView(onQueryChanged = onQueryChanged)
        }
        is SearchUiState.Empty -> {
            InitialView(onQueryChanged = onQueryChanged)
        }
        is SearchUiState.Error -> {
            InitialView(onQueryChanged = onQueryChanged)
        }
    }
}

@Composable
fun InitialView(onQueryChanged: (String) -> Unit) {
    Column() {
        QueryTextField(onQueryChanged = onQueryChanged)
    }
}

@Composable
fun SearchResultsListView(list: List<String>, onQueryChanged: (String) -> Unit) {
    Column() {
        QueryTextField(onQueryChanged = onQueryChanged)
        LazyColumn() {
            items(list) { item ->
                Text(item)
            }

        }
    }
}

@Composable
fun LoadingView(onQueryChanged: (String) -> Unit) {
    Column() {
        QueryTextField(onQueryChanged = onQueryChanged)
//        var text by remember() { mutableStateOf("") }
//        TextField(value = text, onValueChange = {
//            text = it
//            onQueryChanged.invoke(it)
//        })
        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun QueryTextField(onQueryChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    TextField(value = text, onValueChange = {
        text = it
        onQueryChanged.invoke(it)
    })
}

