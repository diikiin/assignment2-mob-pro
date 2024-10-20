package com.dikin.assignment2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dikin.assignment2.R
import com.dikin.assignment2.model.Notification

class NotificationsAdapter(private val notifications: List<Notification>) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>() {

    inner class NotificationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageIV = itemView.findViewById<ImageView>(R.id.notification_image)
        private val messageTV = itemView.findViewById<TextView>(R.id.notification_message)
        private val datetimeTV = itemView.findViewById<TextView>(R.id.notification_datetime)

        fun bind(notification: Notification) {
            messageTV.text = notification.message
            datetimeTV.text = notification.datetime

            Glide.with(itemView.context)
                .load(notification.imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(imageIV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notifications_notification, parent, false)
        return NotificationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
        holder.bind(notifications[position])
    }

    override fun getItemCount(): Int = notifications.size
}