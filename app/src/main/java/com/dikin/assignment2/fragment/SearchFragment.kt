package com.dikin.assignment2.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.SearchAdapter
import com.dikin.assignment2.model.Post
import com.dikin.assignment2.model.User
import kotlin.random.Random

class SearchFragment : Fragment(R.layout.search) {

    private lateinit var searchET: EditText
    private lateinit var searchRV: RecyclerView
    private lateinit var adapter: SearchAdapter
    private var users = getUsers()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchET = view.findViewById(R.id.search_et)
        searchRV = view.findViewById(R.id.search_rv)

        adapter = SearchAdapter()
        searchRV.layoutManager = LinearLayoutManager(context)
        searchRV.adapter = adapter

        searchET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filterResults(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun filterResults(query: String) {
        if (query.isNotEmpty()) {
            val filteredResults = users.filter { user ->
                user.username.contains(query, ignoreCase = true)
            }
            adapter.updateUsers(filteredResults)
        } else {
            adapter.updateUsers(emptyList())
        }
    }

    private fun getUsers(): List<User> {
        val posts = getPosts()
        return listOf(
            User("lazy69", R.drawable.icon1, "The Lovers", posts.size, posts),
            User("babysitter", R.drawable.icon2, "The World", posts.size, posts),
            User("@$$0", R.drawable.icon3, "Strength", posts.size, posts),
            User("D4C", R.drawable.icon4, "Hermit Purple", posts.size, posts),
            User("metallica", R.drawable.icon5, "Hierophant Green", posts.size, posts)
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