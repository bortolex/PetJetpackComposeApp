package com.example.petjetpackcomposeapp.ui.texts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ClassicTextField() {
    var textFieldValue by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextField(value = textFieldValue, onValueChange = { updatedValue ->
            textFieldValue = updatedValue
        })
    }
}

@Composable
fun TextFieldWithBorders() {
    var textFieldValue by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(value = textFieldValue, onValueChange = { updatedValue ->
            textFieldValue = updatedValue
        })
    }
}