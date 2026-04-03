package com.example.petjetpackcomposeapp.draft.states

import androidx.compose.ui.graphics.vector.ImageVector

data class AppBarState(
    val destinationId: String?,
    val icon: ImageVector,
    val onIconClick: (() -> Unit)? = null
)
