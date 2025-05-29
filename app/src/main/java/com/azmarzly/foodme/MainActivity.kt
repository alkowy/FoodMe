package com.azmarzly.foodme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.azmarzly.core.ui.theme.FoodMeTheme
import com.azmarzly.foodme.ui.rememberAppState
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
            FoodMeTheme {
                FoodMeApp(
                    appState = appState,
                    startDestination = viewModel.startDestination
                )
            }
        }
    }
}