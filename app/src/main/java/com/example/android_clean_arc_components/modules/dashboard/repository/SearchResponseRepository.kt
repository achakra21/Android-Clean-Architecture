package com.example.android_clean_arc_components.modules.dashboard.repository

import androidx.lifecycle.MutableLiveData
import com.example.android_clean_arc_components.modules.dashboard.model.SearchResponse
import com.example.android_clean_arc_components.modules.dashboard.networking.RestUtilsService
import com.example.android_clean_arc_components.modules.dashboard.networking.RetrofitFactory
import kotlinx.coroutines.*
import retrofit2.HttpException

class SearchResponseRepository {



    private var movies = mutableListOf<SearchResponse>()
    private var mutableLiveData = MutableLiveData<List<SearchResponse>>()
    val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val thisApiCorService by lazy {
        RetrofitFactory.makeRetrofitService()
    }

    fun getMutableLiveData():MutableLiveData<List<SearchResponse>> {
        coroutineScope.launch {
            val request = thisApiCorService.getPosts()
            withContext(Dispatchers.Main) {
                try {

                    val response = request
                    val mBlogWrapper = response;
                    if (mBlogWrapper != null ) {
                        movies = mBlogWrapper as MutableList<SearchResponse>;
                        mutableLiveData.value=movies;
                    }

                } catch (e: HttpException) {
                    e.printStackTrace()

                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
        }
        return mutableLiveData;
    }

    }





