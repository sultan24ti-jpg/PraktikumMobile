package com.example.bumi_sultan.data.api

import com.example.bumi_sultan.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
