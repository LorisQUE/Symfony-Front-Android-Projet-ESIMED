package com.example.lebonangle.api

import java.io.Serializable

data class AdvertsJsonItem(
    val author: String,
    val category: String,
    val content: String,
    val createdAt: String,
    val email: String,
    val id: Int,
    val price: Float,
    val publishedAt: String,
    val state: String,
    val title: String
):Serializable