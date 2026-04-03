package com.example.petjetpackcomposeapp.draft.server.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductsResponseDto(
    @SerializedName("products") val products: List<ProductDto> = emptyList(),
    @SerializedName("total") val total: Int = 0,
    @SerializedName("skip") val skip: Int = 0,
    @SerializedName("limit") val limit: Int = 0
)

@Keep
data class ProductDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    @SerializedName("thumbnail") val thumbnail: String? = null
)