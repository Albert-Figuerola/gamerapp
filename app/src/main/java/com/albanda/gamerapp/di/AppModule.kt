package com.albanda.gamerapp.di

import com.albanda.gamerapp.core.Constants.USERS
import com.albanda.gamerapp.data.repository.AuthRepositoryImpl
import com.albanda.gamerapp.data.repository.UserRepositoryImpl
import com.albanda.gamerapp.domain.repository.AuthRepository
import com.albanda.gamerapp.domain.repository.UserRepository
import com.albanda.gamerapp.domain.usecase.auth.AuthUseCases
import com.albanda.gamerapp.domain.usecase.auth.GetCurrentUser
import com.albanda.gamerapp.domain.usecase.auth.Login
import com.albanda.gamerapp.domain.usecase.auth.Logout
import com.albanda.gamerapp.domain.usecase.auth.Signup
import com.albanda.gamerapp.domain.usecase.user.CreateUser
import com.albanda.gamerapp.domain.usecase.user.GetUserById
import com.albanda.gamerapp.domain.usecase.user.SaveImage
import com.albanda.gamerapp.domain.usecase.user.UpdateUser
import com.albanda.gamerapp.domain.usecase.user.UserUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(USERS)

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository = authRepositoryImpl

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl

    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(authRepository),
        login = Login(authRepository),
        logout = Logout(authRepository),
        signup = Signup(authRepository)
    )

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) = UserUseCases (
        createUser = CreateUser(userRepository),
        getUserById = GetUserById(userRepository),
        updateUser = UpdateUser(userRepository),
        saveImage = SaveImage(userRepository)
    )
}