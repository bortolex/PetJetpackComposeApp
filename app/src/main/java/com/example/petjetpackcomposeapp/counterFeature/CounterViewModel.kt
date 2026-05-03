package com.example.petjetpackcomposeapp.counterFeature

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CounterViewModel @Inject constructor() : ViewModel() {


    data class ScreenState(
        val counterValue: Int,
        val isIncrementInProgress: Boolean
    )
}