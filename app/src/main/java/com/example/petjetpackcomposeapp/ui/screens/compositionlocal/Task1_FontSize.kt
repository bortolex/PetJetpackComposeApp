package com.example.petjetpackcomposeapp.ui.screens.compositionlocal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * ЗАДАЧА 1: Створи CompositionLocal для розміру шрифту
 *
 * Що потрібно зробити:
 *
 * 1) Створи val LocalFontSize = compositionLocalOf { 16.sp }
 *    (значення за замовчуванням — 16.sp)
 *
 * 2) В Task1Screen() огорни вміст у CompositionLocalProvider
 *    і надай значення 24.sp
 *
 * 3) В StyledText() замість hardcoded 16.sp
 *    прочитай значення через LocalFontSize.current
 *
 * Бонус: спробуй зробити вкладений провайдер з іншим розміром
 *        для другого StyledText
 *
 * Підказка: подивись Example1_Basic.kt — там такий самий патерн,
 * тільки зі String замість TextUnit
 */

// TODO: Крок 1 — створи LocalFontSize тут
val LocalFontSize = compositionLocalOf { 16.sp }

@Composable
fun Task1Screen() {
    CompositionLocalProvider(LocalFontSize provides 48.sp) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Задача 1: LocalFontSize", fontSize = LocalFontSize.current, fontWeight = FontWeight.Bold)

            // TODO: Крок 2 — огорни StyledText у CompositionLocalProvider
            StyledText("Перший текст")
            StyledText("Другий текст")
        }
    }
}

@Composable
fun StyledText(content: String) {
    // TODO: Крок 3 — замість 16.sp використай LocalFontSize.current
    Text(text = content, fontSize = LocalFontSize.current)
}
