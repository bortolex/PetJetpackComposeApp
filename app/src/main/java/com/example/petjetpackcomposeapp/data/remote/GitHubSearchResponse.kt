package com.example.petjetpackcomposeapp.data.remote

import com.google.gson.annotations.SerializedName

data class GitHubSearchResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val items: List<GitHubUser>
)

data class GitHubUser(
    @SerializedName("login") val login: String
)
