package com.example.petjetpackcomposeapp.ui.texts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BorderedTextFieldForContainer() {
    var valueChange by rememberSaveable { mutableStateOf("") }
    val horizontalPadding = Modifier.padding(horizontal = 16.dp)
    OutlinedTextField(
        value = valueChange,
        onValueChange = {
            valueChange = it
        },
        singleLine = true, modifier = horizontalPadding,
    )
    Spacer(Modifier.height(8.dp))
    Text(modifier = horizontalPadding.padding(bottom = 16.dp), text =
        if (valueChange.isBlank()) {
            "[Empty]"
        } else {
            "User is typing: $valueChange"
        }
    )
}


@Composable
fun ClassicTextField() {
    var textFieldValue by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
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
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(value = textFieldValue, onValueChange = { updatedValue ->
            textFieldValue = updatedValue
        })
    }
}