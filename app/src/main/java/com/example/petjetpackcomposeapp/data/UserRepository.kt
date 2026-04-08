package com.example.petjetpackcomposeapp.data


interface UserRepository {
    suspend fun searchUsers(query: String): List<String>
}
