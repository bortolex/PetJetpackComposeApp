package com.example.petjetpackcomposeapp.ui.effects

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.elveum.effects.annotations.SideEffect
import com.example.petjetpackcomposeapp.ExceptionMessageMapper
import com.example.petjetpackcomposeapp.counterFeature.SettingsRoute
import dagger.hilt.android.qualifiers.ActivityContext
import java.lang.Exception

@SideEffect
class NavComponentRouter(
    @ActivityContext private val context: Context,
) : Router {

    private var navController: NavController? = null
    private var lastActionTimestamp = 0L

    override fun popBackStack() = debounce {
        navController?.popBackStack()
    }

    override fun launchSettings() = debounce {
        navController?.navigate(SettingsRoute)
    }

    override fun showError(exception: Exception) {
        val message = ExceptionMessageMapper.DEFAULT.toUserMessage(context, exception)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    private inline fun debounce(action: () -> Unit) {
        val timestamp = System.currentTimeMillis()
        if (timestamp > lastActionTimestamp + 500) {
            action()
        }
        lastActionTimestamp = timestamp
    }

}