package com.dikin.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.MockDataProvider
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.HomeFeedAdapter
import com.dikin.assignment2.databinding.HomeFeedBinding
import com.dikin.assignment2.model.Post

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
        posts = MockDataProvider.posts
        adapter = HomeFeedAdapter(posts)

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }
}