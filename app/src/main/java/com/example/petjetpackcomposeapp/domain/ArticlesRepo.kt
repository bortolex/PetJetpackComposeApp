package com.example.petjetpackcomposeapp.domain

import kotlinx.coroutines.flow.Flow

interface ArticlesRepo {
    fun getArticles(): Flow<Result<List<Article>>>
}