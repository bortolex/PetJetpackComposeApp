package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.example.petjetpackcomposeapp.project.presentation.ArticlesViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.petjetpackcomposeapp.project.domain.Article
import com.example.petjetpackcomposeapp.project.presentation.ArticlesUiState

@Composable
fun ArticlesScreen() {
    val articlesViewModel: ArticlesViewModel = hiltViewModel()
    val state = articlesViewModel.articles.collectAsStateWithLifecycle()
    when (state.value) {
        is ArticlesUiState.Loading -> {
            LoadingView()
        }
        is ArticlesUiState.Error -> {
            ErrorView {
                articlesViewModel.fetchArticles()
            }
        }
        is ArticlesUiState.Success -> {
            ArticlesListView((state.value as ArticlesUiState.Success).data)
        }
    }
}

@Composable
fun ArticlesListView(data: List<Article>) {
//    LazyColumn(data.size) { }
}

@Composable
fun ErrorView(onRetryClick: () -> Unit) { // it's hoisting
    Column() {
        Text("Something went wrong")
        Text(
            text = "Retry", color = Color.Blue,
            modifier = Modifier.clickable {
                onRetryClick.invoke()
            },
            style = TextStyle(textDecoration = TextDecoration.Underline),
        )
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}