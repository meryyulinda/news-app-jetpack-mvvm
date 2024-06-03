package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.dto.NewsReponse
import com.loc.newsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int = 2,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsReponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsReponse

//    @GET("top-headlines")
    @GET("everything")
    suspend fun getHeadlines(
        @Query("pageSize") pageSize: Int = 5,
        @Query("page") page: Int = 1,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsReponse
}