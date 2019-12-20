package com.example.android_clean_arc_components.modules.dashboard.networking

import com.example.android_clean_arc_components.modules.dashboard.model.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RestUtilsService {

    @GET("/posts")
    suspend fun getPosts(): List<SearchResponse>
}