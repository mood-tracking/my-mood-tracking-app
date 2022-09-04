package com.niksob.app.view.mood.entry

import com.niksob.app.R
import com.niksob.app.view.main.activity.base.BaseView
import com.niksob.domain.model.MoodEntriesData

class AdditionMoodEntryView : BaseView() {

    var moodEntryData: MoodEntriesData? = null
        set(entryData) {
            if (field != null) {
                return
            }
            field = entryData
        }

    override val layout = R.layout.addition_mood_entry_view_layout
}