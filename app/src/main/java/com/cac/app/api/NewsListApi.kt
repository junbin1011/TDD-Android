package com.cac.app.api

import com.cac.app.model.NewsResponse
import retrofit2.http.GET

interface NewsListApi {
    @GET("/news/list")
    suspend fun queryNewsList(): NewsResponse
}
