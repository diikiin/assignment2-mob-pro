package com.dikin.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.NotificationAdapter
import com.dikin.assignment2.model.Notification
import kotlin.random.Random

class NotificationFragment : Fragment(R.layout.notifications_notification) {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: NotificationAdapter
    private val notifications = getNotifications()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.notifications_rv)
        adapter = NotificationAdapter(notifications)

        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

    }

    private fun getNotifications(): List<Notification> {
        return List(Random.nextInt(10)) { _ ->
            Notification(getMessage(), getDatetime())
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