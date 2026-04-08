package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.petjetpackcomposeapp.presentation.UserSearchViewModel

@Composable
fun UserSearchScreen() {
    val userSearchViewModel: UserSearchViewModel = hiltViewModel()
    userSearchViewModel
    Column() {
        var text by remember { mutableStateOf("") }
        TextField(value = text, onValueChange = {
            text = it
        })
        LazyColumn() {
            items(){
                Text()
            }

        }
    }

}