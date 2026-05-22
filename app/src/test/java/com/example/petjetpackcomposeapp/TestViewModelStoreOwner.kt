package com.example.petjetpackcomposeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import io.mockk.every
import io.mockk.mockk

class TestViewModelStoreOwner(private val viewModel: ViewModel,

): ViewModelStoreOwner {

    override val viewModelStore: ViewModelStore = mockk{
        val ref = this
        every { ref[any()] } returns viewModel
    }
}