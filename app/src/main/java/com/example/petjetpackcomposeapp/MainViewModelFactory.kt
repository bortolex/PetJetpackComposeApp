package com.example.petjetpackcomposeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.petjetpackcomposeapp.view_models.HomeViewModel

class MainViewModelFactory(
    private val repo: Repo,
    private val userId: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repo, userId) as T
        }
        error("Unknown ViewModel class")
    }
}
