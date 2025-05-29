package com.azmarzly.foodme.navigation

import com.azmarzly.authentication.navigation.LoginBaseRoute
import com.azmarzly.authentication.navigation.LoginRoute
import com.azmarzly.home.HomeBaseRoute
import com.azmarzly.home.HomeRoute
import kotlin.reflect.KClass


enum class TopLevelRoute(
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class,
    ),
    LOGIN(
        route = LoginRoute::class,
        baseRoute = LoginBaseRoute::class,
    ),
}