package com.example.petjetpackcomposeapp.project.data

import retrofit2.http.GET

interface ArticleApiService {
    @GET("news/sport")
    suspend fun getArticles(): NewsResponse
}