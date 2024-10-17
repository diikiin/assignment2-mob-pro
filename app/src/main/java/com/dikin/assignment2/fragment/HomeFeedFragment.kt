package com.dikin.assignment2.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.HomeFeedAdapter
import com.dikin.assignment2.model.Post
import kotlin.random.Random

class HomeFeedFragment : Fragment(R.layout.home_feed) {

    private lateinit var rv: RecyclerView
    private lateinit var posts: List<Post>
    private lateinit var adapter: HomeFeedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.home_feed_rv)
        posts = getPosts()
        adapter = HomeFeedAdapter(posts)

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }

    private fun getPosts(): List<Post> {
        return List(Random.nextInt(10)) { index ->
            Post(
                id = index + 1,
                username = getUsername(),
                imageUrl = getImageUrl(),
                caption = getCaption(),
                likes = getLikes()
            )
        }
    }

    private fun getUsername(): String {
        val usernames = listOf("lazy69", "babysitter", "@$$0", "D4C", "metallica")
        return usernames[Random.nextInt(usernames.size)]
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
            "../res/drawable/1.jpg",
            "../res/drawable/2.jpg",
            "../res/drawable/3.jpg",
            "../res/drawable/4.jpg",
            "../res/drawable/5.jpg"
        )
        return images[Random.nextInt(images.size)]
    }

    private fun getLikes(): Int {
        return Random.nextInt(0, 1001)
    }
}