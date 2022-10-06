package com.niksob.domain.data.repository.auth

import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface AuthRepositoryWithAuthorizedUserIdLoader : AuthRepositoryWithSignOutMaker {
    fun loadAuthorizeUserId(callback: Callback<Query>)
}