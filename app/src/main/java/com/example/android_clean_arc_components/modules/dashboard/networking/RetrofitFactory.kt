package com.example.android_clean_arc_components.modules.dashboard.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    val BASE_URL = "https://jsonplaceholder.typicode.com"

    //here we build service call with model class with coroutine

    fun makeRetrofitService(): RestUtilsService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())

            .build().create(RestUtilsService::class.java)
    }
}