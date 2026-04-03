/*
package com.example.petjetpackcomposeapp.draft.server

import com.example.petjetpackcomposeapp.draft.server.requests.DummyApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    private const val BASE_URL = "https://dummyjson.com/"

//    @OptIn(ExperimentalSerializationApi::class)
//    private val json = Json {
//        ignoreUnknownKeys = true
//        isLenient = true
//        explicitNulls = false
//    }

//    private val logging = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BASIC
//    }
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttp: OkHttpClient = */
/*OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()*//*

        OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).apply {
//                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
//                }

            }.build()

//    Retrofit.Builder().baseUrl(environmentConfigManager.serverUrl)
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().apply {
//        if (includeNulls) {
//            serializeNulls()
//        }
//    }.disableHtmlEscaping().create())).apply {
//        client(if (shortTimeOuts) httpClientShortTimeOuts else httpClient)
//    }.build().create(clazz)

    private val retrofit: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(unsafeOkHttpClient()).addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))

//    fun f(){
//        retrofit.build().create(DummyApi::class.java)
//    }

    val dummyApi: DummyApi by lazy { retrofit.build().create(DummyApi::class.java) }
}*/
