package com.niksob.app.view.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.R
import com.niksob.app.view.ViewComponentsInitializer
import com.niksob.app.view.main.activity.base.BaseView

open class BaseSignUpView : ViewComponentsInitializer, BaseView() {

    override val layout = R.layout.sign_up_view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        initComponents()
        return rootView
    }

    override fun initComponents() = Unit
}