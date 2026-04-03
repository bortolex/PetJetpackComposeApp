package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.runtime.Composable
import com.example.petjetpackcomposeapp.project.presentation.ArticlesViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ArticlesScreen(){
    val articlesViewModel: ArticlesViewModel = hiltViewModel()
    articlesViewModel.articles.collectAsStateWithLifecycle()
}