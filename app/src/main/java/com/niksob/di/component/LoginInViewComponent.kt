package com.niksob.di.component

import com.niksob.di.module.view.login.LoginInViewModule
import com.niksob.app.view.LoginInView
import dagger.Component

@Component(modules = [LoginInViewModule::class])
interface LoginInViewComponent {
    fun inject(loginInView: LoginInView)
}