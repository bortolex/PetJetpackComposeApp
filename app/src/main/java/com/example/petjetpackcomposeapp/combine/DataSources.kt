package com.example.petjetpackcomposeapp.combine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataSource @Inject constructor() {
    fun getUser(): Flow<String> = flow {
        delay(1_000)
        emit("John Doe")
    }
}

@Singleton
class OrdersDataSource @Inject constructor() {
    fun getOrders(): Flow<List<String>> = flow {
        delay(2_000)
        emit(listOf("Order #1", "Order #2", "Order #3"))
    }
}

@Singleton
class SettingsDataSource @Inject constructor() {
    fun getSettings(): Flow<Map<String, String>> = flow {
        delay(500)
        emit(mapOf("theme" to "dark", "language" to "en"))
    }
}
