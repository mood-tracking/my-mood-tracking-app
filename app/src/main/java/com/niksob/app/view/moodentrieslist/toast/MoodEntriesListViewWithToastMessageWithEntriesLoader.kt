package com.niksob.app.view.moodentrieslist.toast

import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.moodentrieslist.progressbar.InjectedMoodEntriesListViewWithEntriesLoaderWithProgressbar
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MoodEntriesListViewWithToastMessageWithEntriesLoader : InjectedMoodEntriesListViewWithEntriesLoaderWithProgressbar() {

    @Inject
    lateinit var toastMessage: ToastMessage

    private val entriesLoadSuccessMessage get() = requireContext().getString(R.string.mood_entries_was_load)

    private val entriesLoadFailedMessage get() = requireContext().getString(R.string.mood_entries_was_not_load)

    override fun onLoadMoodEntriesCompleted(response: Query) {
        super.onLoadMoodEntriesCompleted(response)

        if (response.completed) {
            showSuccessEntriesLoadToastMessage()
        } else {
            showFailedEntriesLoadMessage()
        }
    }

    protected open fun showSuccessEntriesLoadToastMessage() = toastMessage.showShortToast(entriesLoadSuccessMessage)

    protected open fun showFailedEntriesLoadMessage() = toastMessage.showShortToast(entriesLoadFailedMessage)
}