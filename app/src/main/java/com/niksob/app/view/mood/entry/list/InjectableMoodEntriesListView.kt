package com.niksob.app.view.mood.entry.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.inject.InjectableWithComponent
import com.niksob.di.component.InjectableComponent
import com.niksob.di.component.view.moodentry.DaggerAppMoodEntriesListViewComponent

open class InjectableMoodEntriesListView : InjectableWithComponent, BaseMoodEntriesListView() {

    protected open val injectableComponentBuilder: DaggerAppMoodEntriesListViewComponent.Builder
        get() = DaggerAppMoodEntriesListViewComponent.builder()

    override val injectableComponent: InjectableComponent? get() = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = Unit
}