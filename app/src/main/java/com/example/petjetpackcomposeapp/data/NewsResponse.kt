package com.example.petjetpackcomposeapp.data

import androidx.annotation.Keep

@Keep
data class NewsResponse(
    val news: List<ArticleDto>
)
