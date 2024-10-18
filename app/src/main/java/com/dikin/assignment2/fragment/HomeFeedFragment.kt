package com.dikin.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.HomeFeedAdapter
import com.dikin.assignment2.databinding.HomeFeedBinding
import com.dikin.assignment2.model.Post
import kotlin.random.Random

class HomeFeedFragment : Fragment(R.layout.home_feed) {

    private var _binding: HomeFeedBinding? = null
    private val binding get() = _binding!!

    private lateinit var rv: RecyclerView
    private lateinit var posts: List<Post>
    private lateinit var adapter: HomeFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv = binding.homeFeedRv
        posts = getPosts()
        adapter = HomeFeedAdapter(posts)

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }

    private fun getPosts(): List<Post> {
        return List(Random.nextInt(5, 10)) { index ->
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

    private fun getLikes(): Int {
        return Random.nextInt(0, 1001)
    }
}