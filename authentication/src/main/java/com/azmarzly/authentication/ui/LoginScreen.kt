package com.azmarzly.authentication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.Credential
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.azmarzly.authentication.R
import com.azmarzly.core.ui.InputTextField
import com.azmarzly.core.ui.InputType


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginScreenViewModel = hiltViewModel(),
    onSignInNavigate: () -> Unit,
) {

    val isEmailValid = viewModel.isEmailValid.collectAsStateWithLifecycle()
    val isSignInEnabled = viewModel.isSignInEnabled.collectAsStateWithLifecycle()

    LoginScreenContent(
        onSignInNavigate = onSignInNavigate,
        email = viewModel.email,
        password = viewModel.password,
        isEmailValid = isEmailValid.value,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        isSignInEnabled = isSignInEnabled.value,
        onSignInWithGoogleClicked = viewModel::onSignInWithGoogleClicked,
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onSignInNavigate: () -> Unit,
    email: String,
    password: String,
    isEmailValid: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    isSignInEnabled: Boolean,
    onSignInWithGoogleClicked: (Credential) -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(WindowInsets.ime.asPaddingValues())
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = spacedBy(16.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.login_top_image),
            contentDescription = "logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.height(300.dp)
        )
        Text("Welcome back skibidi")

        InputTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Email skibidi",
            errorMessage = if (isEmailValid.not()) "Invalid email skibidi" else null,
            inputType = InputType.EMAIL,
        )

        InputTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = "Password skibidi",
            inputType = InputType.PASSWORD
        )
        Text("Forgot password? skibidi")


        Button(
            onClick = onSignInNavigate,
            enabled = isSignInEnabled,
        ) {
            Text("Sign in skibidi")
        }
        Text("or skibidi")

        AuthenticationButton(
            buttonText = "Sign in with Google skibidi",
            onRequestResult = onSignInWithGoogleClicked
        )

        Text("Don't have an account? Sign up skibidi")

    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenContent(
        modifier = Modifier,
        onSignInNavigate = {},
        email = "",
        password = "",
        isEmailValid = true,
        onEmailChange = {},
        onPasswordChange = {},
        isSignInEnabled = true,
        onSignInWithGoogleClicked = {},
    )
}