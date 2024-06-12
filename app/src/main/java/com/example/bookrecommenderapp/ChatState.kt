package com.example.bookrecommenderapp

import android.graphics.Bitmap
import com.example.bookrecommenderapp.data.Chat


data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)