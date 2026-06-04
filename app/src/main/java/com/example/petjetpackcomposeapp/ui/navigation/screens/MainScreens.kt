package com.example.petjetpackcomposeapp.ui.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(onItemClick: () -> Unit) {
    val testList = listOf("asdoiasd", "f.e.", "experiment", "californication", "medical plasters", "SOMETHING", "asdoiasd", "f.e.", "experiment", "californication", "medical plasters", "SOMETHING")
    Spacer(modifier = Modifier.padding(top = 16.dp))
    LazyColumn {
        items(testList) { item ->
            HomeListItem(item, modifier = Modifier.clickable { onItemClick() })
        }
    }
}

@Composable
fun HomeListItem(item: String, modifier: Modifier) {
    Text(item, modifier = modifier.padding(horizontal = 16.dp))
    Spacer(Modifier.height(24.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen() {
    AlertDialog(onDismissRequest = {}, dismissButton = {
        TextButton(onClick = {}, modifier = Modifier.background(Color.Blue)) { }
    }, confirmButton = {
        Button(modifier = Modifier.background(color = Color.Cyan), onClick = {
//            Toast.makeText()
        }) { }
    })
}