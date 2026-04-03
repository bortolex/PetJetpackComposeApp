package com.example.petjetpackcomposeapp.draft.viewModels.newOne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.server.models.Product
import com.example.petjetpackcomposeapp.server.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewHomeViewModel(private val repository: ProductsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NewHomeUiState())
    val homeUiState: StateFlow<NewHomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts(20, 0)
        }
    }

    //todo: 1- question to Korch: can we wrap it in result and flow here: in ViewModel
    fun loadProducts(limit: Int, skip: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            runCatching {
                repository.getProducts(20, 0)
            }.onSuccess {

            }.onFailure { e ->
                _uiState.update { it.copy(isLoading = false, error = e.message ?: "Unknown error") }
                println(e.cause?.message + e.message)
            }

        }
    }
}

data class NewHomeUiState(
    val isLoading: Boolean = false,
    val items: List<Product> = emptyList(),
    val error: String? = null
)