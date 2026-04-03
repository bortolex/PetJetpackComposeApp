package com.example.petjetpackcomposeapp.draft.server.repository

import com.example.petjetpackcomposeapp.server.NetworkModule
import com.example.petjetpackcomposeapp.server.requests.DummyApi
import com.example.petjetpackcomposeapp.server.models.Product
import com.example.petjetpackcomposeapp.server.models.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ProductsRepository {
    suspend fun getProducts(limit: Int, skip: Int): List<Product>
    suspend fun getProductDetails(id: Int): Product
}

class ProductsRepositoryImpl : ProductsRepository {
    private val networkModule = NetworkModule
    private val api: DummyApi
        get() = networkModule.dummyApi

    override suspend fun getProducts(limit: Int, skip: Int): List<Product> = withContext(Dispatchers.IO) {
        api.getProducts(limit = limit, skip = skip).products.map { it.toDomain() }
    }

    override suspend fun getProductDetails(id: Int): Product = withContext(Dispatchers.IO) {
        api.getProductDetails(id).toDomain()
    }
}
