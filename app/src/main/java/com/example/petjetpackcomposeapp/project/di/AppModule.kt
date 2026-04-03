package com.example.petjetpackcomposeapp.project.di

import com.example.petjetpackcomposeapp.project.data.ArticleApiService
import com.example.petjetpackcomposeapp.project.data.ArticlesRepoImpl
import com.example.petjetpackcomposeapp.project.domain.ArticlesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakenews.squirro.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleApi(retrofit: Retrofit): ArticleApiService {
        return retrofit.create(ArticleApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticlesRepo(service: ArticleApiService): ArticlesRepo {
        return ArticlesRepoImpl(service)
    }

}