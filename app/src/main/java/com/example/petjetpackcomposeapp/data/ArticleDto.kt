package com.example.petjetpackcomposeapp.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ArticleDto(
    val id: Int,

    @SerializedName("headline")
    val title: String,

    @SerializedName("body")
    val content: String,

    @SerializedName("article_uri")
    val url: String,

    val author: String
)
