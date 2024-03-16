package com.shifat.smarthallcatering.di

import com.google.firebase.auth.FirebaseAuth
import com.shifat.smarthallcatering.data.AuthRepository
import com.shifat.smarthallcatering.data.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl


}

