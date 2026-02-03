package com.example.petjetpackcomposeapp.server.repository

import com.example.petjetpackcomposeapp.server.requests.DummyApi
import com.example.petjetpackcomposeapp.server.models.Product
import com.example.petjetpackcomposeapp.server.models.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ProductsRepository {
    suspend fun getProducts(limit: Int, skip: Int): List<Product>
    suspend fun getProductDetails(id: Int): Product
}

class ProductsRepositoryImpl(
    private val api: DummyApi
) : ProductsRepository {

    override suspend fun getProducts(limit: Int, skip: Int): List<Product> = withContext(Dispatchers.IO) {
        api.getProducts(limit = limit, skip = skip).products.map { it.toDomain() }
    }

    override suspend fun getProductDetails(id: Int): Product = withContext(Dispatchers.IO) {
        api.getProductDetails(id).toDomain()
    }
}
