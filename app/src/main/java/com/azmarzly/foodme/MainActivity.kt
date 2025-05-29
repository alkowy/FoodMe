package com.azmarzly.foodme

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.azmarzly.foodme.ui.rememberAppState
import com.azmarzly.foodme.ui.theme.FoodMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        splashScreen.setKeepOnScreenCondition { false }

        setContent {
            val appState = rememberAppState()

            Log.d("ANANAS", "MainActivity.kt - onCreate: ${viewModel.startDestination}")
            FoodMeTheme {
                FoodMeApp(
                    appState = appState,
                    startDestination = viewModel.startDestination
                )
            }
        }
    }
}