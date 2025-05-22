package com.azmarzly.foodme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.azmarzly.authentication.ui.AuthenticationButton
import com.azmarzly.foodme.ui.theme.FoodMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodMeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThemeButtonsDemo()
                }
            }
        }
    }
}

@Composable
fun ThemeButtonsDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Buttons Demo", style = MaterialTheme.typography.titleLarge)

        AuthenticationButton(
            buttonText = "Sign in with Google",
            onRequestResult = {},
        )
        Button(onClick = {}) {
            Text("Primary Button")
        }

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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}