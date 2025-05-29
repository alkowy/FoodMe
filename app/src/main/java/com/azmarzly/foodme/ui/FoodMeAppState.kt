package com.azmarzly.foodme.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.azmarzly.authentication.navigation.navigateToLoginScreen
import com.azmarzly.foodme.navigation.TopLevelRoute
import com.azmarzly.home.navigateToHome
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): FoodMeAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        FoodMeAppState(
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}

@Stable
class FoodMeAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val currentTopLevelDestination: TopLevelRoute?
        @Composable get() {
            return TopLevelRoute.entries.firstOrNull { topLevelDestination ->
                currentDestination?.hasRoute(topLevelDestination.route) == true
            }
        }

    val topLevelRoutes: List<TopLevelRoute> = TopLevelRoute.entries

    fun navigateToTopLevelDestination(topLevelRoute: TopLevelRoute) {
        topLevelRoutes.filter { it != topLevelRoute }.forEach { graph ->
            navController.popBackStack(graph.baseRoute, inclusive = true)
        }
        val topLevelNavOptions = navOptions {
            launchSingleTop = true
        }

        when (topLevelRoute) {
            TopLevelRoute.HOME -> navController.navigateToHome(topLevelNavOptions)
            TopLevelRoute.LOGIN -> navController.navigateToLoginScreen(topLevelNavOptions)
        }
    }
}