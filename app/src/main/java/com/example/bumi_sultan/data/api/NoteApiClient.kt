package com.example.bumi_sultan.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NoteApiClient {
    private const val BASE_URL = "https://izckbuqqsgqrdfhwoefr.supabase.co/rest/v1/note"

    val apiService: NoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NoteApiService::class.java)
    }
}
