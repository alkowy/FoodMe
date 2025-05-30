package com.azmarzly.authentication.ui

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import com.azmarzly.authentication.utils.GoogleSignInManager
import com.azmarzly.authentication.utils.googleSignIn
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import kotlinx.coroutines.launch


//todo remove
@Composable
fun AuthButtonWrapperTemp(modifier: Modifier = Modifier) {
    AuthenticationButton("Sign in with Google", {})
}

@Composable
fun AuthenticationButton(buttonText: String, onRequestResult: (Credential) -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = {
            googleSignIn(
                googleSignInManager = GoogleSignInManager(),
                context = context,
                clientId = context.getString(com.azmarzly.authentication.R.string.default_web_client_id),
                coroutineScope = coroutineScope,
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = com.google.firebase.appcheck.interop.R.drawable.googleg_standard_color_18),
            modifier = Modifier.padding(horizontal = 16.dp),
            contentDescription = "Google logo"
        )

        Text(
            text = buttonText,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 6.dp)
        )
    }
}