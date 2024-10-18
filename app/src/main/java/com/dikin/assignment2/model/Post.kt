package com.dikin.assignment2.model

data class Post(
    val id: Int,
    var username: String = "",
    val imageUrl: Int = -1,
    val caption: String = "",
    var likes: Int = 0
) {
    fun like() {
        likes++
    }
}