package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * textField is the same as editTxt
 *
 *
 * these 2 below textFields are immutable. Because all components in jetpackCompose are immutable.
 * It means that always it has the same text as we set in "value" field.
 * Even when user would be trying to change it will not be changed.
 */
@Composable
fun TextFieldScreen(){ // textField is the same as editTxt
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        TextField(value = "TextField1", onValueChange = { newTextValue ->

        })

    }
}

@Composable
fun OutlinedTextFieldScreen(){ // textField is the same as editTxt
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        OutlinedTextField(value = "OutlinedTextField", onValueChange = { newTextValue ->

        })

    }
}