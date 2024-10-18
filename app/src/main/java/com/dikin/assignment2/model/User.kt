package com.dikin.assignment2.model

data class User(
    val username: String,
    val profilePictureUrl: Int,
    val bio: String,
    var postsCount: Int,
    var posts: MutableList<Post>,
    var notifications: MutableList<Notification>
) {
    fun addPost(post: Post) {
        posts.add(post)
        postsCount++
    }
}
