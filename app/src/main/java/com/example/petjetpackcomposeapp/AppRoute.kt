package com.example.petjetpackcomposeapp

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compose_navigation.navigation.Destination

sealed class AppRoute(@StringRes val titleRes: Int): Destination {

    object AddItem: AppRoute(R.string.add_item)

    sealed class Tab(@StringRes titleRes: Int, val icon: ImageVector): AppRoute(titleRes){
        object Items: Tab(R.string.items_name, Icons.Default.Home)
        object Profile: Tab(R.string.profile_name, Icons.Default.AccountBox)
        object Settings: Tab(R.string.settings_name, Icons.Default.Settings)
    }
}