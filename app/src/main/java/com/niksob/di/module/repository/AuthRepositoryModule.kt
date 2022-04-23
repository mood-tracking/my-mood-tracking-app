package com.niksob.di.module.repository

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.data.storage.db.firebase.DbAuthFirebase
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.di.module.storage.FirebaseModule
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.domain.data.repository.AuthRepository
import dagger.Module
import dagger.Provides

@Module(includes = [FirebaseModule::class, StringStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRepository(storage: DbAuthStorage): AuthRepository = AuthRepositoryImpl(storage)

    @Provides
    fun provideDbAuthStorage(
        auth: FirebaseAuth,
        stringStorage: AppStringStorage
    ): DbAuthStorage = DbAuthFirebase(auth, stringStorage)
}