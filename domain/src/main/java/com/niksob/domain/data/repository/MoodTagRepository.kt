package com.niksob.domain.data.repository

import com.niksob.domain.model.Query

interface MoodTagRepository {
    fun loadByEntryId(request: Query)
}
