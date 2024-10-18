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
import com.dikin.assignment2.MockDataProvider
import com.dikin.assignment2.R
import com.dikin.assignment2.adapter.SearchAdapter

class SearchFragment : Fragment(R.layout.search) {

    private lateinit var searchET: EditText
    private lateinit var searchRV: RecyclerView
    private lateinit var adapter: SearchAdapter

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
            val filteredResults = MockDataProvider.users.filter { user ->
                user.username.contains(query, ignoreCase = true)
            }
            adapter.updateUsers(filteredResults)
        } else {
            adapter.updateUsers(emptyList())
        }
    }

}