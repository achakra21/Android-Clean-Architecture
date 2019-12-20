package com.example.android_clean_arc_components.modules.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_clean_arc_components.modules.dashboard.model.SearchResponse
import com.example.android_clean_arc_components.modules.dashboard.repository.SearchResponseRepository

class DashboardViewModel : ViewModel() {

    val movieRepository= SearchResponseRepository()
    val allBlog: LiveData<List<SearchResponse>> get() = movieRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        movieRepository.completableJob.cancel()
    }
}