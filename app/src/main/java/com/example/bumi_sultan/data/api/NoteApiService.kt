package com.example.bumi_sultan.data.api

import com.example.bumi_sultan.data.model.NoteModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NoteApiService {
    @Headers(
        "apikey: sb_publishable_aTH5go94H0OlHxi5XaYMdA_Vyp71Qyi",
        "Authorization: Bearer sb_publishable_aTH5go94H0OlHxi5XaYMdA_Vyp71Qyi",
        "Content-Type: application/json"
    )
    @GET("note")
    suspend fun getNotes(): List<NoteModel>

    @Headers(
        "apikey: sb_publishable_aTH5go94H0OlHxi5XaYMdA_Vyp71Qyi",
        "Authorization: Bearer sb_publishable_aTH5go94H0OlHxi5XaYMdA_Vyp71Qyi",
        "Content-Type: application/json",
        "Prefer: return=representation"
    )
    @POST("note")
    suspend fun addNote(@Body note: NoteModel): List<NoteModel>
}
