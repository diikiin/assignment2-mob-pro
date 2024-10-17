package com.dikin.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.PostsAdapter
import com.dikin.assignment2.model.Post
import com.dikin.assignment2.model.User
import kotlin.random.Random

class ProfileFragment : Fragment(R.layout.profile) {

    private lateinit var profilePictureIV: ImageView
    private lateinit var usernameTV: TextView
    private lateinit var bioTV: TextView
    private lateinit var postsCountTV: TextView
    private lateinit var postsRV: RecyclerView
    private lateinit var adapter: PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profilePictureIV = view.findViewById(R.id.profile_picture)
        usernameTV = view.findViewById(R.id.profile_username)
        bioTV = view.findViewById(R.id.profile_bio)
        postsCountTV = view.findViewById(R.id.profile_posts_count)
        postsRV = view.findViewById(R.id.profile_rv)

        val user = getUser()

        adapter = PostsAdapter(user.posts)
        postsRV.layoutManager = GridLayoutManager(context, 3)
        postsRV.adapter = adapter
    }

    private fun getUser(): User {
        val posts = getPosts()
        return User(
            "D4C",
            "drawable/icon1.jpg",
            "I love Android Studio!",
            posts.size,
            posts
        )
    }

    private fun getPosts(): List<Post> {
        return List(Random.nextInt(10)) { index ->
            Post(
                id = index + 1,
                username = "D4C",
                imageUrl = getImageUrl(),
                caption = getCaption(),
                likes = getLikes()
            )
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

    private fun getImageUrl(): String {
        val images = listOf(
            "drawable/icon1.jpg",
            "drawable/icon2.jpg",
            "../res/drawable/3.jpg",
            "../res/drawable/4.jpg",
            "drawable/icon5.jpg"
        )
        return images[Random.nextInt(images.size)]
    }

    private fun getLikes(): Int {
        return Random.nextInt(1001)
    }
}