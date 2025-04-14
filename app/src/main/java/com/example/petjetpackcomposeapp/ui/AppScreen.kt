package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview (showSystemUi = true)
@Composable
fun AppScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ){
//Container(){}
        Container(name = "ButtonsExample"){
            SimpleButtonInBox("just a button")
        }
        Container(name = "TextFieldExample"){
            StateTextFieldComponent()
        }
        Container(name = "CheckBoxExample"){
            CheckBoxComponent()
        }
    }
}


