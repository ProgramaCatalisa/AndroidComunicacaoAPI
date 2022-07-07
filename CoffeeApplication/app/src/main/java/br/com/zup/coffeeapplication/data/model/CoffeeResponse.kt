package br.com.zup.coffeeapplication.data.model

import com.google.gson.annotations.SerializedName

data class CoffeeResponse(
    @SerializedName("file")
    val arquivo: String = ""
)