package com.example.bumi_sultan.data.model

data class NoteModel(
    val id: Long?,
    val title: String,
    val content: String,
    val status: String?,
    val created_at: String?
)
