package com.azmarzly.authentication

import com.azmarzly.core.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : AuthenticationRepository {

    override fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading)
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        if (result.user != null) {
            emit(Resource.Success(Unit))
        } else {
            emit(Resource.Error("ananas, signin failed"))
        }
    }

    override fun signInWithGoogle(credential: AuthCredential): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading)

    }

    override fun signOut(): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun isSignedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun signUpWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun resetPassword(email: String): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(email: String): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }
}