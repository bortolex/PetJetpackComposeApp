package com.example.petjetpackcomposeapp.data

import com.example.petjetpackcomposeapp.data.remote.GitHubApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: GitHubApiService
) : UserRepository {

    override suspend fun searchUsers(query: String): List<String> {
        val response = apiService.searchUsers(query)
        return response.items.map { it.login }
    }
}
