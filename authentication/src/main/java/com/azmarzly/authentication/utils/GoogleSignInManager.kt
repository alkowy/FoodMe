package com.azmarzly.authentication.utils

import android.content.Context
import android.util.Log
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import java.util.UUID
import javax.inject.Inject

internal class GoogleSignInManager @Inject constructor() {

    private lateinit var credentialManager: CredentialManager

    suspend fun googleSignIn(
        context: Context,
        clientId: String,
        enableChooser: Boolean = false,
        doOnSuccess: (GoogleIdTokenCredential) -> Unit,
        doOnError: (Exception) -> Unit,
        doOnCancel: () -> Unit,
    ) {
        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)
        if (available != ConnectionResult.SUCCESS) {
            doOnError(Exception("Google Play Services not available: $available"))
            return
        }

        if (::credentialManager.isInitialized.not()) {
            credentialManager = CredentialManager
                .create(context)
        }

//        val rawNance = UUID.randomUUID().toString()
//        val bytes = rawNance.toByteArray()
//        val md = MessageDigest.getInstance("SHA-256")
//        val digest = md.digest(bytes)
//        val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }

        val googleSignInOptions = GetSignInWithGoogleOption
            .Builder(clientId)
//            .setNonce(hashedNonce)
            .build()

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption
            .Builder()
//            .setNonce(hashedNonce)
            .setServerClientId(clientId)
            .build()

        val request: GetCredentialRequest = GetCredentialRequest
            .Builder()
            .addCredentialOption(googleSignInOptions)
            .build()

        requestSignIn(
            context = context,
            request = request,
            clientId = clientId,
            doOnSuccess = doOnSuccess,
            doOnError = doOnError,
            doOnCancel = doOnCancel,
        )
    }

    private suspend fun requestSignIn(
        context: Context,
        request: GetCredentialRequest,
        clientId: String,
        doOnSuccess: (GoogleIdTokenCredential) -> Unit,
        doOnError: (Exception) -> Unit,
        doOnCancel: () -> Unit,
    ) {
        try {
            val result = credentialManager.getCredential(
                request = request,
                context = context,
            )
            val credential = handleCredentials(result.credential)
            if (credential != null) {
                Log.d("ANANAS", "GoogleSignInManager.kt - requestSignIn: success")
                doOnSuccess(credential)
            } else {
                Log.d("ANANAS", "GoogleSignInManager.kt - requestSignIn: error")
                doOnError(Exception("Failed to extract Google credentials"))
            }
        } catch (e: Exception) {
            Log.d("ANANAS", "GoogleSignInManager.kt - requestSignIn: catch : ${e.message}")
            when (e) {
                is NoCredentialException -> {
                    googleSignIn(
                        context = context,
                        clientId = clientId,
                        enableChooser = true,
                        doOnSuccess = doOnSuccess,
                        doOnError = doOnError,
                        doOnCancel = doOnCancel,
                    )
                }

                is GetCredentialCancellationException -> {
                    doOnCancel()
                }

                else -> {
                    doOnError(e)
                }
            }
        }
    }

    private fun handleCredentials(credential: Credential): GoogleIdTokenCredential? {
        return when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        GoogleIdTokenCredential.createFrom(credential.data)
                    } catch (e: GoogleIdTokenParsingException) {
                        println("Received an invalid google id token response $e")
                        null
                    }
                } else {
                    println("Unexpected type of credential")
                    null
                }
            }

            else -> {
                println("Unexpected type of credential")
                null
            }
        }
    }
}