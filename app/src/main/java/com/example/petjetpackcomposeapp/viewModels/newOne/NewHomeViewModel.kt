package com.example.petjetpackcomposeapp.viewModels.newOne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.server.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewHomeViewModel(private val repository: ProductsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts(20, 0)
        }

    }
}