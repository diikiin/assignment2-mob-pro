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
import com.dikin.assignment2.model.User
import java.io.File

class SearchAdapter(private var users: List<User>) :
    RecyclerView.Adapter<SearchAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profilePictureIV =
            itemView.findViewById<ImageView>(R.id.search_user_profile_picture)
        private val usernameTV = itemView.findViewById<TextView>(R.id.search_user_username)
        private val bioTV = itemView.findViewById<TextView>(R.id.search_user_bio)

        fun bind(user: User) {
            usernameTV.text = user.username
            bioTV.text = user.bio

            Glide.with(itemView.context)
                .load(File(user.profilePictureUrl))
                .into(profilePictureIV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateUsers(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
    }
}