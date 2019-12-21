package com.example.android_clean_arc_components.modules.room.view

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_clean_arc_components.MainActivity
import com.example.android_clean_arc_components.R
import com.example.android_clean_arc_components.modules.room.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.fragment_notifications.*

class RoomFragment : Fragment() {

    private val newWordActivityRequestCode = 1
    private lateinit var wordViewModel: WordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview1)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)


        // Get a new or existing ViewModel from the ViewModelProvider.
        // wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setWords(it) }
        })
        return root
    }
}