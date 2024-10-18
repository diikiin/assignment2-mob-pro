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
import com.dikin.assignment2.adapter.NotificationsAdapter

class NotificationsFragment : Fragment(R.layout.notifications_notification) {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: NotificationsAdapter

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
        adapter = NotificationsAdapter(MockDataProvider.getUser(1).notifications)

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }
}