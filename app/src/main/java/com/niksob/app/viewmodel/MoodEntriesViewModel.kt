package com.niksob.app.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase
import java.time.ZonedDateTime


private const val LOADED_DAYS_INTERVAL = 5
private const val AUTH_FAILED_REASON_ID = "authorize_failed"

private const val UID_REQUEST_STATUS_LOG_MESSAGE_PREFIX = "Loading current user id is success: "
private const val MOOD_ENTRIES_REQUEST_STATUS_LOG_MESSAGE_PREFIX = "Loading mood entries is success: "
private const val REQUEST_REASON_LOG_MESSAGE_PREFIX = ", reason: "


class MoodEntriesViewModel(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val loadMoodEntriesByUserIdUseCase: LoadMoodEntriesByUserIdUseCase,
    private val stringProvider: AppStringProvider,
) : ViewModel() {

    private val TAG get() = MoodEntriesViewModel::class.simpleName

    private val _moodEntriesResponse = MutableLiveData<Query>()

    val moodEntriesResponse: LiveData<Query> get() = _moodEntriesResponse

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadMoodEntriesByUserId() {

        val callback = Callback<Query> { userIdResponse ->
            onAuthorizeUserIdLoaded(userIdResponse)
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }

    fun loadMoodEntries(entriesData: MoodEntriesData) {

        val request = Query(
            data = entriesData,
            callback = Callback { moodEntriesResponse ->

                Log.d(
                    TAG, MOOD_ENTRIES_REQUEST_STATUS_LOG_MESSAGE_PREFIX + moodEntriesResponse.completed
                            + REQUEST_REASON_LOG_MESSAGE_PREFIX + moodEntriesResponse.reason
                )
                _moodEntriesResponse.value = moodEntriesResponse
            }
        )
        loadMoodEntriesByUserIdUseCase.execute(request)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onAuthorizeUserIdLoaded(userIdResponse: Query) {

        Log.d(
            TAG, UID_REQUEST_STATUS_LOG_MESSAGE_PREFIX + userIdResponse.completed
                    + REQUEST_REASON_LOG_MESSAGE_PREFIX + userIdResponse.reason
        )

        if (!userIdResponse.completed) {
            _moodEntriesResponse.value = Query(
                reason = stringProvider.getString(AUTH_FAILED_REASON_ID)
            )
            return
        }

        val entriesData = MoodEntriesData(
            uid = userIdResponse.data as String,
            dateTime = ZonedDateTime.now(),
            loadedDaysInterval = LOADED_DAYS_INTERVAL
        )
        loadMoodEntries(entriesData)
    }
}