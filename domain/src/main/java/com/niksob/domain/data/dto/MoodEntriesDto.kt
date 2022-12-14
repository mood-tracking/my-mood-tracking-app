package com.niksob.domain.data.dto

import com.niksob.domain.model.Uid

data class MoodEntriesDto(
    val uid: Uid,
    val data: List<MoodEntryDto>,
)
