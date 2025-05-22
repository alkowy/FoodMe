package com.azmarzly.authentication.di

import com.azmarzly.authentication.AuthenticationRepository
import com.azmarzly.authentication.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthenticationBindingModule {

    @Binds
    @Singleton
    abstract fun bindAuthenticationRepository(repo: AuthenticationRepositoryImpl): AuthenticationRepository
}