package com.azmarzly.foodme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.azmarzly.foodme.ui.FoodMeAppState
import com.azmarzly.home.HomeBaseRoute
import com.azmarzly.home.homeSection
import com.azmarzly.profile.navigation.profileSection

@Composable
fun FoodMeNavHost(
    appState: FoodMeAppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = HomeBaseRoute,
        modifier = modifier,
    ) {
        homeSection()
        profileSection()
    }
}