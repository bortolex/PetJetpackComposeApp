package com.example.petjetpackcomposeapp.draft.server.models

import com.example.petjetpackcomposeapp.server.dto.ProductDto

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnail: String?,
    val fullText: String
)

fun ProductDto.toDomain(): Product = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    thumbnail = thumbnail,
    fullText = title + description + price
)