package com.example.petjetpackcomposeapp.ui.screens.compositionlocal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import javax.annotation.meta.TypeQualifierNickname

/**
 * ЗАДАЧА 2: Налаштування користувача через CompositionLocal
 *
 * Це складніша задача — поєднує data class + CompositionLocal + стан.
 *
 * Що потрібно зробити:
 *
 * 1) Створи data class UserSettings з двома полями:
 *    - nickname: String
 *    - favoriteColor: Color
 *
 * 2) Створи val LocalUserSettings = compositionLocalOf { ... }
 *    зі значенням за замовчуванням (наприклад UserSettings("Anonymous", Color.Gray))
 *
 * 3) В Task2Screen() є кнопка яка перемикає між двома наборами налаштувань.
 *    Огорни контент у CompositionLocalProvider і надай поточні налаштування.
 *
 * 4) В UserCard() — прочитай налаштування через LocalUserSettings.current
 *    і покажи nickname як текст, а favoriteColor як фон Box.
 *
 * Підказка: подивись Example2_ThemeColors.kt — там схожий підхід з data class*/

data class UserSettings(
    val nickname: String,
    val favoriteColor: Color
)

val LocalUserSettings = compositionLocalOf { UserSettings("Budyak", Color.Gray) }

// TODO: Крок 1 — створи data class UserSettings

// TODO: Крок 2 — створи LocalUserSettings


val settingsA =  UserSettings("Олександр", Color(0xFF1976D2))
val settingsB = UserSettings("Тарас", Color(0xFFE91E63))

@Composable
fun Task2Screen() {
    var isFirstUser by remember { mutableStateOf(true) }
    val currentSettings = if (isFirstUser) settingsA else settingsB

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Задача 2: UserSettings", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        CompositionLocalProvider(LocalUserSettings provides currentSettings) {
            UserCard()
        }

        Button(onClick = { isFirstUser = !isFirstUser }) {
            Text("Переключити користувача")
        }
    }
}

@Composable
fun UserCard() {
    // TODO: Крок 4 — прочитай LocalUserSettings.current
    //  і покажи nickname та favoriteColor

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TODO: ${LocalUserSettings.current.nickname} тут",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(LocalUserSettings.current.favoriteColor) // TODO: замінити на favoriteColor
                .padding(24.dp)
        ) {
            Text("Улюблений колір", color = LocalUserSettings.current.favoriteColor)
        }
    }
}
