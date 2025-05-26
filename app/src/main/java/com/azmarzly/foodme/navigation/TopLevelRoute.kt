package com.azmarzly.foodme.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.azmarzly.home.HomeBaseRoute
import com.azmarzly.home.HomeRoute
import com.azmarzly.profile.navigation.ProfileBaseRoute
import com.azmarzly.profile.navigation.ProfileRoute
import kotlin.reflect.KClass

enum class TopLevelRoute(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = com.azmarzly.foodme.R.string.app_name,
        titleTextId = com.azmarzly.foodme.R.string.app_name,
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class,
    ),
    PROFILE(
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        iconTextId = com.azmarzly.foodme.R.string.app_name,
        titleTextId = com.azmarzly.foodme.R.string.app_name,
        route = ProfileRoute::class,
        baseRoute = ProfileBaseRoute::class,
    )
}