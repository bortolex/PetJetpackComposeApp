package com.example.petjetpackcomposeapp.ui.screens.compositionlocal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
 * ПРИКЛАД 1: Базовий CompositionLocal
 *
 * Проблема: ми хочемо показати ім'я користувача в глибоко вкладеному composable,
 * але не хочемо прокидувати його через кожен рівень.
 *
 * Рішення: CompositionLocal — створюємо "невидиму змінну",
 * яку може прочитати будь-який composable всередині провайдера.
 */

// Крок 1: Створюємо CompositionLocal.
// "Guest" — значення за замовчуванням, якщо ніхто не надав інше.
val LocalUserName = compositionLocalOf { "Guest" }

@Composable
fun Example1Screen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Приклад 1: Базовий CompositionLocal", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        // Без провайдера — буде значення за замовчуванням ("Guest")
        Card(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Без провайдера:", fontWeight = FontWeight.SemiBold)
                GreetingCard() // покаже "Guest"
            }
        }

        // Крок 2: Надаємо значення через CompositionLocalProvider
        CompositionLocalProvider(LocalUserName provides "Oleksandr") {
            // Все що тут всередині — бачить "Oleksandr"
            Card(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("З провайдером (Oleksandr):", fontWeight = FontWeight.SemiBold)
                    GreetingCard() // покаже "Oleksandr"
                }
            }
        }

        // Можна надати інше значення — вкладені провайдери перекривають зовнішні
        CompositionLocalProvider(LocalUserName provides "Taras") {
            Card(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("З іншим провайдером (Taras):", fontWeight = FontWeight.SemiBold)
                    GreetingCard() // покаже "Taras"
                }
            }
        }
    }
}

// Крок 3: Читаємо значення через .current
// Зверни увагу: ця функція НЕ приймає userName як параметр!
// Вона дістає його "неявно" через CompositionLocal.
@Composable
fun GreetingCard() {
    val userName = LocalUserName.current // ← ось тут магія
    Text("Привіт, $userName! 👋", fontSize = 18.sp)
}
