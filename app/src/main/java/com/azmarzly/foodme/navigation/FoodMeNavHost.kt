package com.azmarzly.foodme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.azmarzly.authentication.navigation.loginSection
import com.azmarzly.foodme.ui.FoodMeAppState
import com.azmarzly.home.homeSection

@Composable
fun FoodMeNavHost(
    appState: FoodMeAppState,
    startDestination: TopLevelRoute,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination.baseRoute,
        modifier = modifier,
    ) {
        loginSection(
            onSignInNavigate = {
                appState.navigateToTopLevelDestination(topLevelRoute = TopLevelRoute.HOME)
            }
        )
        homeSection(
            navController = navController,
            onSignOutNavigate = {
                appState.navigateToTopLevelDestination(topLevelRoute = TopLevelRoute.LOGIN)
            }
        )
    }
}