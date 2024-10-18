package com.dikin.assignment2

import com.dikin.assignment2.model.Notification
import com.dikin.assignment2.model.Post
import com.dikin.assignment2.model.User
import kotlin.random.Random

object MockDataProvider {

    val users = getAllUsers()
    val posts = getAllPosts()

    fun getUser(position: Int): User {
        return users[position]
    }

    private fun getAllUsers(): List<User> {
        val posts1 = getPosts("lazy69")
        val posts2 = getPosts("babysitter")
        val posts3 = getPosts("@$$0")
        val posts4 = getPosts("D4C")
        val posts5 = getPosts("metallica")
        return listOf(
            User("lazy69", R.drawable.icon1, "The Lovers", posts1.size, posts1, getNotifications()),
            User(
                "babysitter",
                R.drawable.icon2,
                "The World",
                posts2.size,
                posts2,
                getNotifications()
            ),
            User("@$$0", R.drawable.icon3, "Strength", posts3.size, posts3, getNotifications()),
            User("D4C", R.drawable.icon4, "Hermit Purple", posts4.size, posts4, getNotifications()),
            User(
                "metallica",
                R.drawable.icon5,
                "Hierophant Green",
                posts5.size,
                posts5,
                getNotifications()
            )
        )
    }

    private fun getAllPosts(): MutableList<Post> {
        var posts = mutableListOf<Post>()
        users.forEach { user -> posts.addAll(user.posts) }
        return posts
    }

    private fun getPosts(username: String): MutableList<Post> {
        return MutableList(Random.nextInt(1, 10)) { index ->
            Post(index + 1, username, getImageUrl(), getCaption(), getLikes())
        }
    }

    private fun getCaption(): String {
        val captions = listOf(
            "Some another day",
            "Happy Holidays!",
            "Scary af",
            "Why are you gay?",
            "Ooooooo!"
        )
        return captions[Random.nextInt(captions.size)]
    }

    private fun getImageUrl(): Int {
        val images = listOf(
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3,
            R.drawable.icon4,
            R.drawable.icon5
        )
        return images[Random.nextInt(images.size)]
    }

    fun getImageUrl(hashcode: Int): Int {
        return if (hashcode % 2 == 0)
            R.drawable.icon2
        else
            R.drawable.icon3
    }

    private fun getLikes(): Int {
        return Random.nextInt(0, 1001)
    }

    private fun getNotifications(): MutableList<Notification> {
        return MutableList(Random.nextInt(1, 10)) { index ->
            Notification(index + 1, getImageUrl(), getMessage(), getDatetime())
        }
    }

    private fun getMessage(): String {
        val messages = listOf(
            "${getUsername()} liked your post",
            "${getUsername()} wrote a comment"
        )

        return messages[Random.nextInt(messages.size)]
    }

    private fun getUsername(): String {
        val usernames = listOf("lazy69", "babysitter", "@$$0", "D4C", "metallica")
        return usernames[Random.nextInt(usernames.size)]
    }

    private fun getDatetime(): String {
        val datetimes = listOf("5 minutes ago", "Just now", "1 hour ago")
        return datetimes[Random.nextInt(datetimes.size)]
    }
}