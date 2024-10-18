package com.dikin.assignment2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dikin.assignment2.R
import com.dikin.assignment2.model.Post

class HomeFeedAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<HomeFeedAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val usernameTV = itemView.findViewById<TextView>(R.id.post_username)
        private val imageIV = itemView.findViewById<ImageView>(R.id.post_image)
        private val captionTV = itemView.findViewById<TextView>(R.id.post_caption)
        private val likesTV = itemView.findViewById<TextView>(R.id.post_likes)

        @SuppressLint("SetTextI18n")
        fun bind(post: Post) {
            usernameTV.text = post.username
            captionTV.text = post.caption
            likesTV.text = "${post.likes} likes"

            Glide.with(itemView.context)
                .load(post.imageUrl)
                .into(imageIV)

            itemView.setOnClickListener {
                post.like()
                likesTV.text = "${post.likes} likes"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size
}