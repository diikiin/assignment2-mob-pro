package com.dikin.assignment2.model

data class User(
    val username: String,
    val profilePictureUrl: Int,
    val bio: String,
    val postsCount: Int,
    val posts: List<Post>
)
