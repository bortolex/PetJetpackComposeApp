package com.example.petjetpackcomposeapp.project.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(val repo: ArticlesRepo) {
    operator fun invoke(): Flow<Result<List<Article>>> {
        return repo.getArticles()
    }
}