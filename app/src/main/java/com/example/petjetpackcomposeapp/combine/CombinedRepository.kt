package com.example.petjetpackcomposeapp.combine

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton

data class DashboardData(
    val userName: String,
    val orders: List<String>,
    val settings: Map<String, String>,
)

@Singleton
class CombinedRepository @Inject constructor(
    private val userDataSource: UserDataSource,
    private val ordersDataSource: OrdersDataSource,
    private val settingsDataSource: SettingsDataSource,
) {
    fun getDashboard(): Flow<DashboardData> = combine(
        userDataSource.getUser(),
        ordersDataSource.getOrders(),
        settingsDataSource.getSettings(),
    ) { user, orders, settings ->
        DashboardData(
            userName = user,
            orders = orders,
            settings = settings,
        )
    }
}
