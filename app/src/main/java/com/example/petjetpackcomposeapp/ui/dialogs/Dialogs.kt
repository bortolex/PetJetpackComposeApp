package com.example.petjetpackcomposeapp.ui.dialogs

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun DialogApp(modifier: Modifier) {
    val context = LocalContext.current
    Box(modifier) {
        var isDialogVisible by remember { mutableStateOf(false) }
        Button(onClick = {
            isDialogVisible = true
        }) {
            Text("Show dialog")
        }
        if (isDialogVisible) {
            AlertDialog(onDismissRequest = {
                isDialogVisible = false
            }, confirmButton = {
                TextButton(onClick = {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Ok")
                }

            }, title = {
                Text("Test Dialog")
            }, text = { Text("This is a test dialog") })
        }
    }
}