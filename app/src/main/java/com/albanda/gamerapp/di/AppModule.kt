package com.albanda.gamerapp.di

import com.albanda.gamerapp.data.repository.AuthRepositoryImpl
import com.albanda.gamerapp.domain.repository.AuthRepository
import com.albanda.gamerapp.domain.usecase.auth.AuthUseCases
import com.albanda.gamerapp.domain.usecase.auth.GetCurrentUser
import com.albanda.gamerapp.domain.usecase.auth.Login
import com.albanda.gamerapp.domain.usecase.auth.Logout
import com.albanda.gamerapp.domain.usecase.auth.Signup
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository = authRepositoryImpl

    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(authRepository),
        login = Login(authRepository),
        logout = Logout(authRepository),
        signup = Signup(authRepository)
    )
}