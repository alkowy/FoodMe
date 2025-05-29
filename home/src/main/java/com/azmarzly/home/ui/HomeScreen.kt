package com.azmarzly.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.azmarzly.authentication.ui.AuthButtonWrapperTemp
import com.azmarzly.core.ui.InputTextField
import com.azmarzly.core.ui.InputType

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToProfile: () -> Unit) {
    HomeScreenContent(
        modifier = modifier,
        onNavigateToProfile = onNavigateToProfile,
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    onNavigateToProfile: () -> Unit,
) {
    ThemeButtonsDemo(onNavigateToProfile = onNavigateToProfile)
}

@Composable
fun ThemeButtonsDemo(
    onNavigateToProfile: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Buttons Demo", style = MaterialTheme.typography.titleLarge)

        AuthButtonWrapperTemp()
        Button(onClick = onNavigateToProfile) {
            Text("NAVIGATE TO PROFILE SKIBIDI")
        }

        InputTextFieldDemo()
        OutlinedButton(onClick = {}) {
            Text("Outlined Button")
        }

        TextButton(onClick = {}) {
            Text("Text Button")
        }
        ColorShowcase()
    }
}

@Composable
fun ColorShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Theme Color Showcase", style = MaterialTheme.typography.titleLarge)

        listOf(
            "Primary" to MaterialTheme.colorScheme.primary,
            "Secondary" to MaterialTheme.colorScheme.secondary,
            "Tertiary" to MaterialTheme.colorScheme.tertiary,
            "Surface" to MaterialTheme.colorScheme.surface,
            "Background" to MaterialTheme.colorScheme.background,
            "Error" to MaterialTheme.colorScheme.error
        ).forEach { (label, color) ->
            ColorBox(label, color)
        }
    }
}

@Composable
fun ColorBox(label: String, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = contentColorFor(color))
    }
}

@Composable
fun InputTextFieldDemo(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        InputTextField(
            value = name,
            onValueChange = { name = it },
            label = "Name",
            inputType = InputType.NAME,
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant
        )

        InputTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            inputType = InputType.EMAIL,
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant
        )

        InputTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            inputType = InputType.PASSWORD,
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            errorMessage = if (password.length in 1..<4) "Too short" else null
        )
    }
}