package com.niksob.app.view.mood.entry.list.uicomponent

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.mood.entry.MoodEntryAdapter
import com.niksob.app.view.mood.entry.list.mvvm.InjectableMVVMMoodEntriesListView
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.Query

open class MoodEntriesListWithRecycleView : InjectableMVVMMoodEntriesListView() {

    protected lateinit var moodEntryRecycleView: RecyclerView

    protected open fun initMoodEntriesList(moodEntries: MoodEntries) {
        moodEntryRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries)
        }
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)
        initMoodEntriesList(response.data as MoodEntries)
    }

    override fun initComponents() {
        super.initComponents()
        moodEntryRecycleView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
    }
}