package com.azmarzly.authentication

import com.azmarzly.core.Resource
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    fun signInWithGoogle(credential: AuthCredential): Flow<Resource<Unit>>
    fun signOut(): Flow<Resource<Unit>>
    fun isSignedIn(): Boolean
    fun signUpWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    fun resetPassword(email: String): Flow<Resource<Unit>>
    fun forgotPassword(email: String): Flow<Resource<Unit>>
}