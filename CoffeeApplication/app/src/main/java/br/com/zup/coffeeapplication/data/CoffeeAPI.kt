package br.com.zup.coffeeapplication.data

import br.com.zup.coffeeapplication.data.model.CoffeeResponse
import retrofit2.http.GET

interface CoffeeAPI {

    @GET("random.json")
    suspend fun getImageCoffee(): CoffeeResponse
}