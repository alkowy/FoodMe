package com.azmarzly.authentication

import android.util.Log
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import com.azmarzly.authentication.model.UserData
import com.azmarzly.core.Resource
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
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

    override fun signInWithGoogle(credential: Credential): Flow<Resource<UserData>> = flow {
        emit(Resource.Loading)

        val googleIdToken = (credential as? CustomCredential)
            ?.takeIf { it.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL }
            ?.let { GoogleIdTokenCredential.createFrom(it.data).idToken }
        Log.d("ANANAS", "AuthenticationRepositoryImpl.kt - signInWithGoogle: idtoken $googleIdToken")
        if (googleIdToken == null) {
            emit(Resource.Error("Invalid credential type"))
            return@flow
        }

        val googleAuthCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
        Log.d("ANANAS", "AuthenticationRepositoryImpl.kt - signInWithGoogle: googleAuthCredential $googleAuthCredential")
        try {
            val user = firebaseAuth.signInWithCredential(googleAuthCredential).await().user
            Log.d("ANANAS", "AuthenticationRepositoryImpl.kt - signInWithGoogle: user $user")
            if (user == null) {
                emit(Resource.Error("Failed to retrieve user"))
                return@flow
            }

            val userData = UserData(
                userId = user.uid,
                name = user.displayName.orEmpty(),
                profilePictureUrl = user.photoUrl?.toString().orEmpty(),
                email = user.email.orEmpty()
            )

            emit(Resource.Success(userData))
        } catch (e: Exception) {
            Log.d("ANANAS", "AuthenticationRepositoryImpl.kt - signInWithGoogle: catch ${e.localizedMessage}")
            emit(Resource.Error("Authentication failed: ${e.localizedMessage ?: "Unknown error"}"))
        }
    }


    override fun signOut(): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun isSignedIn(): Boolean = firebaseAuth.currentUser != null

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