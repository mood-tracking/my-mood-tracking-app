package com.niksob.app.view.moodentrieslist.viewmodel.entryloader

import com.niksob.app.view.moodentrieslist.navigation.InjectedNavigatableMoodEntriesListView
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MoodEntriesListViewWithEntriesLoader : InjectedNavigatableMoodEntriesListView() {

    @Inject
    lateinit var moodEntriesViewModel: MoodEntriesListViewModel

    protected open fun loadMoodEntriesByUserId() {
        moodEntriesViewModel.loadMoodEntriesByUserId()
    }

    protected open fun onLoadMoodEntriesCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
    }
}