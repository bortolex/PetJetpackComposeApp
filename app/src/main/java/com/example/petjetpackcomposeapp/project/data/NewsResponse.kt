package com.example.petjetpackcomposeapp.project.data

import androidx.annotation.Keep

@Keep
data class NewsResponse(
    val news: List<ArticleDto>
)
