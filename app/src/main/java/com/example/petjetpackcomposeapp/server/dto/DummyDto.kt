package com.example.petjetpackcomposeapp.server.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName

@Keep
data class ProductsResponseDto(
    @SerialName("products") val products: List<ProductDto> = emptyList(),
    @SerialName("total") val total: Int = 0,
    @SerialName("skip") val skip: Int = 0,
    @SerialName("limit") val limit: Int = 0
)

@Keep
data class ProductDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("price") val price: Double,
    @SerialName("thumbnail") val thumbnail: String? = null
)