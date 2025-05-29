package com.azmarzly.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignInNavigate: () -> Unit,
) {
    LoginScreenContent(
        onSignInNavigate = onSignInNavigate,
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onSignInNavigate: () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Button(onClick = onSignInNavigate) {
            Text("Sign in skibidi")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenContent(
        modifier = Modifier,
        onSignInNavigate = {},
    )
}