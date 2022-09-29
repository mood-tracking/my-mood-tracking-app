package com.niksob.app.view.auth.signup.viewmodel.useraddition

import com.niksob.app.view.auth.signup.viewmodel.signup.InjectableMVVMSignUpView
import com.niksob.app.viewmodel.auth.signup.useraddition.SignUpViewModelWithNewUserAddition
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

open class MVVMSignUpWithUserAdderView : InjectableMVVMSignUpView() {

    protected val signUpViewModelWithNewUserAddition get() = signUpViewModel as SignUpViewModelWithNewUserAddition

    protected open fun addUser(user: User) = signUpViewModelWithNewUserAddition.addUser(user)

    protected open fun onAddUserCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
        moveToMoodEntriesScreen()
    }
}