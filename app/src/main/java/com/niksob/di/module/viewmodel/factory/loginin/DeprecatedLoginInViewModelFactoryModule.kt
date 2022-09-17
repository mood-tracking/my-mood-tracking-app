package com.niksob.di.module.viewmodel.factory.loginin

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.loginin.deprecated.DeprecatedLoginInViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.auth.LoginInWithEmailAndPasswordUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoginInWithEmailAndPasswordUseCaseModule::class,
        LoginValidationModule::class,
        StringStorageModule::class
    ]
)
class DeprecatedLoginInViewModelFactoryModule {
    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        DeprecatedLoginInViewModelFactory(
            loginInUseCase = loginInUseCase,
            validateEmailUseCase = validateEmailUseCase,
            validatePasswordUseCase = validatePasswordUseCase,
            stringProvider = stringProvider,
        )
}