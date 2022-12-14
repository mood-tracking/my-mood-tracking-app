package com.niksob.data.storage.firebase.base.saver

import com.google.android.gms.tasks.Task
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface FirebaseSaver {
    fun save(task: Task<Void>, callback: Callback<Query>)
}