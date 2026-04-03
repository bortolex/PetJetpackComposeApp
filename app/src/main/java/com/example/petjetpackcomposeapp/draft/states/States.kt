package com.example.petjetpackcomposeapp.draft.states

sealed interface ScreenState<out T> { //todo: investigate question if it was as <T> not <out T>

    data object Loading : ScreenState<Nothing>

    data class Content<T>(
        val data: T
    ) : ScreenState<T>

    data class Empty(
        val message: String? = null
    ) : ScreenState<Nothing>

//    data class Error(
//        val message: String,
//        val canRetry: Boolean = true
//    ) : ScreenState<Nothing>
data class Error(val message: UiText, val canRetry: Boolean = true) : ScreenState<Nothing>
}

sealed interface UiText {
    data class Plain(val value: String) : UiText
    data class Res(@androidx.annotation.StringRes val resId: Int) : UiText
}
