package com.example.petjetpackcomposeapp.project.domain

import kotlinx.coroutines.flow.Flow

interface ArticlesRepo {
    fun getArticles(): Flow<Result<List<Article>>>
}