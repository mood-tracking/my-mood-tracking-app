package com.niksob.data.storage.firebase.auth.authorizer.reason

import com.niksob.data.model.ResponseReasonName
import com.niksob.data.storage.firebase.base.reason.ResponseReasonProviderImpl
import com.niksob.data.storage.provider.AppStringStorage

open class AuthorizerResponseReasonProvider(
    stringStorage: AppStringStorage,
) : ResponseReasonProviderImpl(stringStorage) {

    override val successReasonId get() = ResponseReasonName.SUCCESS_AUTH_REASON.value

    override val failureReasonId get() = ResponseReasonName.FAILED_AUTH_REASON.value
}