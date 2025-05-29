package com.azmarzly.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.azmarzly.authentication.ui.LoginScreen
import com.azmarzly.authentication.ui.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute

@Serializable
data object SignUpRoute

@Serializable
data object LoginBaseRoute

fun NavController.navigateToLoginScreen(navOptions: NavOptions) =
    navigate(route = LoginRoute, navOptions)

fun NavGraphBuilder.loginSection(onSignInNavigate: () -> Unit) {
    navigation<LoginBaseRoute>(startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen(onSignInNavigate = onSignInNavigate)
        }
        composable<SignUpRoute> {
            SignUpScreen()
        }
    }
}