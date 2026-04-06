package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.petjetpackcomposeapp.project.presentation.ArticlesViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.petjetpackcomposeapp.project.domain.Article
import com.example.petjetpackcomposeapp.project.presentation.ArticlesUiState

@Composable
fun ArticlesScreen(onItemClick: (Article) -> Unit = {}) {
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
            ArticlesListView((state.value as ArticlesUiState.Success).data){
                onItemClick.invoke(it)
            }
        }
    }
}

@Composable
fun ArticleDetailsScreen(articleId: String?) {

}

@Composable
fun ArticlesListView(data: List<Article>,  onItemClickSuccess: (Article) -> Unit = {}) {
    LazyColumn(modifier = Modifier) {
        items(data) { item ->
            Surface( modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { onItemClickSuccess(item) },
                shape = RoundedCornerShape(16.dp),
                color = Color.Gray,
                shadowElevation = 6.dp) { }
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                Text(item.title, style = TextStyle(textDecoration = TextDecoration.Underline))
                Spacer(Modifier.height(24.dp))
//                Text(item.content, style = TextStyle(textDecoration = TextDecoration.Underline))
//                Spacer(Modifier.height(24.dp))
                Text(item.url, style = TextStyle(textDecoration = TextDecoration.Underline))
                Spacer(Modifier.height(24.dp))
            }
        }
    }
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