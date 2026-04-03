package com.example.petjetpackcomposeapp.project.data

import com.example.petjetpackcomposeapp.project.domain.Article
import com.example.petjetpackcomposeapp.project.domain.ArticlesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jsoup.Jsoup


class ArticlesRepoImpl(
    private val api: ArticleApiService
) : ArticlesRepo {

    override fun getArticles(): Flow<Result<List<Article>>> = flow {
        try {
            val response = api.getArticles()

            val articles = response.news.map { dto ->
                dto.copy(
                    content = Jsoup.parse(dto.content).text() // removes html tags
                ).toDomain()
            }

            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
        .flowOn(Dispatchers.IO)
}

fun ArticleDto.toDomain(): Article {
    return Article(
//        id = this.id,
        title = this.title,
        content = this.content,
        url = this.url,
//        author = this.author

    )
}