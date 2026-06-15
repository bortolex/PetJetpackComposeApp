package com.example.petjetpackcomposeapp.search

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor() {

    suspend fun search(query: String): List<String> {
        delay(300) // imitate network request
        return listOf(
            "$query result 1",
            "$query result 2",
            "$query result 3",
        )
    }
}
