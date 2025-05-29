package com.azmarzly.home

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import androidx.navigation.navigation
import com.azmarzly.home.ui.HomeScreen
import com.azmarzly.profile.ui.ProfileScreen
import kotlinx.serialization.Serializable

interface HomeSubRoute

@Serializable
data object HomeRoute : HomeSubRoute

@Serializable
data object HomeProfileRoute : HomeSubRoute

@Serializable
data object HomeBaseRoute

fun NavController.navigateToHome(navOptions: NavOptions) =
    navigate(route = HomeRoute, navOptions)

fun NavController.navigateToProfile(navOptions: NavOptions) =
    navigate(route = HomeProfileRoute, navOptions)

fun NavController.navigateToHomeSubRoute(route: HomeSubRoute) {
    val currentDestId = this.currentDestination?.id ?: this.graph.findStartDestination().id
    val navOptions = navOptions {
        popUpTo(currentDestId) {
            inclusive = true
            saveState = false
        }
        launchSingleTop = true
        restoreState = false
    }
    when (route) {
        HomeRoute -> this.navigateToHome(navOptions)
        HomeProfileRoute -> this.navigateToProfile(navOptions)
    }
}


fun NavGraphBuilder.homeSection(
    navController: NavController,
    onSignOutNavigate: () -> Unit,
) {
    navigation<HomeBaseRoute>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(
                onNavigateToProfile = {
                    navController.navigateToHomeSubRoute(HomeProfileRoute)
                }
            )
        }
        composable<HomeProfileRoute> {
            ProfileScreen(
                onSignOutNavigate = onSignOutNavigate,
                onNavigateToHome = {
                    navController.navigateToHomeSubRoute(HomeRoute)
                },
            )
        }
    }
}