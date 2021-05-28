package com.timotiushaniel.bajp3.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.timotiushaniel.bajp3.data.source.model.FilmResult

data class FilmResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val results: List<FilmResult>,

    @SerializedName("total_results")
    val totalResults: Int?
)