package com.example.petjetpackcomposeapp.ui.effects

import java.lang.Exception

interface Router {
    fun popBackStack()
    fun launchSettings()
    fun showError(exception: Exception)
}