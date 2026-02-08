package com.example.petjetpackcomposeapp.viewModels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.petjetpackcomposeapp.server.repository.ProductsRepositoryImpl
import com.example.petjetpackcomposeapp.viewModels.newOne.NewHomeViewModel

class MainViewModelFactory(
//    private val isAdmin: Boolean,
    private val owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when {
            modelClass.isAssignableFrom(NewHomeViewModel::class.java) -> {
                NewHomeViewModel(ProductsRepositoryImpl())
            }

//            modelClass.isAssignableFrom(AdminViewModel::class.java) -> {
//                AdminViewModel(AdminRepository(), handle)
//            }

            else -> error("Unknown ViewModel: $modelClass")
        } as T
    }

}
