package com.azmarzly.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onSignOutNavigate: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    ProfileContent(
        modifier = modifier,
        onSignOutNavigate = onSignOutNavigate,
        onNavigateToHome = onNavigateToHome
    )
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    onSignOutNavigate: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Button(onClick = onSignOutNavigate) {
            Text("Sign out skibidi")
        }
        Button(onClick = onNavigateToHome) {
            Text("navigate home skibidi")
        }
        (1..100).forEach {
            Text("skibidi $it")
        }
    }
}