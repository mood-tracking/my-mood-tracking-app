package com.niksob.di.module.repository.auth

import com.niksob.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoaderImpl
import com.niksob.data.repository.auth.AuthRepositoryWithAuthorizerImpl
import com.niksob.data.repository.auth.AuthRepositoryWithRegistrarImpl
import com.niksob.data.repository.auth.AuthRepositoryWithSignOutMakerImpl
import com.niksob.data.storage.auth.auth_registrar.AuthRegistrar
import com.niksob.data.storage.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.auth.authorizer.Authorizer
import com.niksob.data.storage.auth.signout.SignOutMaker
import com.niksob.di.module.storage.db.auth.AuthStorageModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoader
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizer
import com.niksob.domain.data.repository.auth.AuthRepositoryWithRegistrar
import com.niksob.domain.data.repository.auth.AuthRepositoryWithSignOutMaker
import dagger.Module
import dagger.Provides

@Module(includes = [AuthStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRegistrar(registrar: AuthRegistrar): AuthRepositoryWithRegistrar =
        AuthRepositoryWithRegistrarImpl(registrar)

    @Provides
    fun provideAuthorizedUserIdLoader(loader: AuthorizedUserIdLoader): AuthRepositoryWithAuthorizedUserIdLoader =
        AuthRepositoryWithAuthorizedUserIdLoaderImpl(loader)

    @Provides
    fun provideSignOutMaker(maker: SignOutMaker): AuthRepositoryWithSignOutMaker =
        AuthRepositoryWithSignOutMakerImpl(maker)

    @Provides
    fun provideFirebaseAuthorizer(authorizer: Authorizer): AuthRepositoryWithAuthorizer =
        AuthRepositoryWithAuthorizerImpl(authorizer)
}