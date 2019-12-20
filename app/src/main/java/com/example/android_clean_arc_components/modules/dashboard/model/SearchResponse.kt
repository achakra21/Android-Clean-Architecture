package com.example.android_clean_arc_components.modules.dashboard.model

import com.squareup.moshi.Json

data class SearchResponse (@field:Json(name = "userId")val userId:Int,
                           @field:Json(name = "id")val id:Int, @field:Json(name = "title")
                           val title:String, @field:Json(name = "body")val body:String) {

}