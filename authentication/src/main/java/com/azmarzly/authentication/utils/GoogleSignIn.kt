package com.azmarzly.authentication.utils

import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


internal fun googleSignIn(
    googleSignInManager: GoogleSignInManager?,
    context: Context,
    clientId: String,
    coroutineScope: CoroutineScope,
) {
    coroutineScope.launch {
        googleSignInManager?.googleSignIn(
            context = context,
            clientId = clientId,
            doOnSuccess = { googleIdTokenCredential ->
                Log.d("ANANAS", "GoogleSignIn.kt - googleSignIn: success $googleIdTokenCredential")
            },
            doOnError = { Log.d("ANANAS", "GoogleSignIn.kt - googleSignIn: onerror ${it.message}")  },
            doOnCancel = { Log.d("ANANAS", "GoogleSignIn.kt - googleSignIn: oncacnel ")  },
        )
    }
}