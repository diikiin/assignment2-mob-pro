package com.dikin.assignment2.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dikin.assignment2.MockDataProvider
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.ProfilePostAdapter

class ProfileFragment : Fragment(R.layout.profile) {

    private lateinit var profilePictureIV: ImageView
    private lateinit var usernameTV: TextView
    private lateinit var bioTV: TextView
    private lateinit var postsCountTV: TextView
    private lateinit var postsRV: RecyclerView
    private lateinit var adapter: ProfilePostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profilePictureIV = view.findViewById(R.id.profile_picture)
        usernameTV = view.findViewById(R.id.profile_username)
        bioTV = view.findViewById(R.id.profile_bio)
        postsCountTV = view.findViewById(R.id.profile_posts_count)
        postsRV = view.findViewById(R.id.profile_rv)

        val user = MockDataProvider.getUser(1)

        usernameTV.text = user.username
        bioTV.text = user.bio
        postsCountTV.text = "${user.postsCount} posts"

        Glide.with(this)
            .load(user.profilePictureUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(profilePictureIV)

        adapter = ProfilePostAdapter(user.posts)
        postsRV.layoutManager = GridLayoutManager(context, 3)
        postsRV.adapter = adapter
    }

}