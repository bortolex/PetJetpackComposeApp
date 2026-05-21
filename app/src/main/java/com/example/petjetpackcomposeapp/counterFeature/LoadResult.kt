package com.example.petjetpackcomposeapp.counterFeature

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed class LoadResult<out T> {
    data object Loading : LoadResult<Nothing>()
    data class Success<T>(val value: T) : LoadResult<T>()
    data class Error(val exception: Exception) : LoadResult<Nothing>()
}

inline fun <T, R> LoadResult<T>.map(mapper: (T) -> R): LoadResult<R> {
    return when (this) {
        LoadResult.Loading -> LoadResult.Loading
        is LoadResult.Error -> this
        is LoadResult.Success -> LoadResult.Success(mapper(value))
    }
}

inline fun <T> MutableStateFlow<LoadResult<T>>.updateIfSuccess(updater: (T) -> T) {
    update {
        it.map(updater)
    }
}