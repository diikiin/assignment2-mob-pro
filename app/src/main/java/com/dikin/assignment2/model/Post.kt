package com.dikin.assignment2.model

data class Post(
    val id: Int,
    val username: String,
    val imageUrl: Int,
    val caption: String,
    var likes: Int
) {
    fun like() {
        likes++
    }
}