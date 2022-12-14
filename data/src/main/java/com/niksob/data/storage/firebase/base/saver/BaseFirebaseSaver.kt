package com.niksob.data.storage.firebase.base.saver

import com.google.android.gms.tasks.Task
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class BaseFirebaseSaver(
    private val action: OnDataSavedAction,
) : FirebaseSaver {

    private fun onComplete(task: Task<Void>, callback: Callback<Query>) =
        if (task.isSuccessful)
            action.onDataLoaded(callback)
        else
            action.onDataCancelled(task, callback)

    override fun save(task: Task<Void>, callback: Callback<Query>) {
        task.addOnCompleteListener { onComplete(task, callback) }
    }
}