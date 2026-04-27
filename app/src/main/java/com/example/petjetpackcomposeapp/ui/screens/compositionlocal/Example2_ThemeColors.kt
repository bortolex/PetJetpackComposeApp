package com.example.petjetpackcomposeapp.ui.screens.compositionlocal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * ПРИКЛАД 2: staticCompositionLocalOf — власна "міні-тема"
 *
 * Цей приклад показує як MaterialTheme працює під капотом.
 * Ми створюємо свій набір кольорів і передаємо їх вниз по дереву.
 *
 * Використовуємо staticCompositionLocalOf, бо тема змінюється рідко
 * (тільки коли користувач натискає кнопку).
 */

// Наш власний клас з кольорами (спрощена версія того, що робить MaterialTheme)
data class AppColors(
    val background: Color,
    val text: Color,
    val accent: Color
)

// Два набори кольорів
val LightColors = AppColors(
    background = Color(0xFFF5F5F5),
    text = Color(0xFF212121),
    accent = Color(0xFF1976D2)
)

val DarkColors = AppColors(
    background = Color(0xFF212121),
    text = Color(0xFFFFFFFF),
    accent = Color(0xFFBB86FC)
)

// staticCompositionLocalOf — бо кольори змінюються рідко
// Якщо значення не надано — кидаємо помилку (немає значення за замовчуванням)
val LocalAppColors = staticCompositionLocalOf { LightColors }

@Composable
fun Example2Screen() {
    var isDark by remember { mutableStateOf(false) }
    val colors = if (isDark) DarkColors else LightColors

    // Провайдимо кольори — все дерево всередині їх бачить
    CompositionLocalProvider(LocalAppColors provides colors) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalAppColors.current.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Приклад 2: Власна тема",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LocalAppColors.current.text
            )

            // Ці composable не приймають кольори як параметри —
            // вони дістають їх самі через LocalAppColors.current
            ThemedCard("Картка 1")
            ThemedCard("Картка 2")
            ColorPreview()

            Button(onClick = { isDark = !isDark }) {
                Text(if (isDark) "Світла тема" else "Темна тема")
            }
        }
    }
}

@Composable
fun ThemedCard(title: String) {
    // Зчитуємо кольори з CompositionLocal — не з параметрів!
    val colors = LocalAppColors.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.accent.copy(alpha = 0.1f))
            .padding(16.dp)
    ) {
        Text(title, color = colors.text, fontSize = 16.sp)
    }
}

@Composable
fun ColorPreview() {
    val colors = LocalAppColors.current
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(modifier = Modifier.size(40.dp).background(colors.background))
        Box(modifier = Modifier.size(40.dp).background(colors.text))
        Box(modifier = Modifier.size(40.dp).background(colors.accent))
    }
}
