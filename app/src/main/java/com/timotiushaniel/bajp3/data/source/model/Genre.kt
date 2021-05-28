package com.timotiushaniel.bajp3.data.source.model

import com.google.gson.annotations.SerializedName

data class Genre(

    @SerializedName("name")
    val name: String?,

    @SerializedName("id")
    val id: Int?
)