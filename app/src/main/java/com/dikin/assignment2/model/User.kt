package com.dikin.assignment2.model

data class User(
    val username: String,
    val profilePictureUrl: String,
    val bio: String,
    val postsCount: Int,
    val posts: List<Post>
)
