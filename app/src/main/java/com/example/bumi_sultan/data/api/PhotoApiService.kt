package com.example.bumi_sultan.data.api

import com.example.bumi_sultan.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
