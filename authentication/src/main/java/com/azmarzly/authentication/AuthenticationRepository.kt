package com.azmarzly.authentication

import androidx.credentials.Credential
import com.azmarzly.authentication.model.UserData
import com.azmarzly.core.Resource
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    fun signInWithGoogle(credential: Credential): Flow<Resource<UserData>>
    fun signOut(): Flow<Resource<Unit>>
    fun isSignedIn(): Boolean
    fun signUpWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    fun resetPassword(email: String): Flow<Resource<Unit>>
    fun forgotPassword(email: String): Flow<Resource<Unit>>
}