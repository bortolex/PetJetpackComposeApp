package com.example.petjetpackcomposeapp.draft.server.requests

import com.example.petjetpackcomposeapp.server.dto.ProductDto
import com.example.petjetpackcomposeapp.server.dto.ProductsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface DummyApi {
    @GET("/products/")
    suspend fun getProducts(
        @Query("limit") limit: Int = 20,
        @Query("skip") skip: Int = 0
    ): ProductsResponseDto

    @GET("products/{id}")
    suspend fun getProductDetails(
        @Path("id") id: Int
    ): ProductDto
}