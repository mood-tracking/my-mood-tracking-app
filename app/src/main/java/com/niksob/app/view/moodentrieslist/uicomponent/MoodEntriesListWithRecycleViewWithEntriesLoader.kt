package com.niksob.app.view.moodentrieslist.uicomponent

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.moodentrieslist.adapter.MoodEntryAdapter
import com.niksob.app.view.moodentrieslist.viewmodel.entryloader.InjectedMoodEntriesListViewWithEntriesLoader
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.Query

open class MoodEntriesListWithRecycleViewWithEntriesLoader : InjectedMoodEntriesListViewWithEntriesLoader() {

    protected lateinit var moodEntryRecycleView: RecyclerView

    protected open fun initMoodEntriesList(moodEntries: MoodEntries) {
        moodEntryRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries)
        }
    }

    override fun onLoadMoodEntriesCompleted(response: Query) {
        if (!response.completed) {
            return
        }
        initMoodEntriesList(response.data as MoodEntries)
    }

    override fun initComponents() {
        super.initComponents()
        moodEntryRecycleView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
    }
}