package com.example.petjetpackcomposeapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService {

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("per_page") perPage: Int = 20
    ): GitHubSearchResponse
}
