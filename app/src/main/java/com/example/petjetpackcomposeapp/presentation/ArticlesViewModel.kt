package com.example.petjetpackcomposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.domain.Article
import com.example.petjetpackcomposeapp.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {

    private val _articles by lazy {
        MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading).also { fetchArticles() }
    }
    val articles: StateFlow<ArticlesUiState> = _articles.asStateFlow()

    private fun fetchArticles(){
        viewModelScope.launch {
            _articles.emit(ArticlesUiState.Loading)
            getArticlesUseCase()
                .onStart { _articles.emit(ArticlesUiState.Loading) }
                .collect { result ->
                    _articles.emit(
                        when {
                            result.isSuccess -> ArticlesUiState.Success(result.getOrDefault(emptyList()))
                            result.isFailure -> {
                                ArticlesUiState.Error(
                                    result.exceptionOrNull()?.localizedMessage ?: "Error loading"
                                )
                            }

                            else -> ArticlesUiState.Error("Unknown error")
                        }
                    )
                }
        }
    }

}
sealed class ArticlesUiState {
    data object Loading : ArticlesUiState()
    data class Success(val data: List<Article>) : ArticlesUiState()
    data class Error(val message: String) : ArticlesUiState()
}