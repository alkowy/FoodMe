package com.azmarzly.foodme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.azmarzly.foodme.navigation.FoodMeNavHost
import com.azmarzly.foodme.navigation.TopLevelRoute
import com.azmarzly.foodme.ui.FoodMeAppState

@Composable
fun FoodMeApp(
    appState: FoodMeAppState,
    startDestination: TopLevelRoute,
    modifier: Modifier = Modifier,
) {
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        bottomBar = {
//            NavigationBar {
//                TopLevelRoute.entries.forEach { route ->
//                    val isSelected = appState.currentTopLevelDestination?.route == route.route
//                    NavigationBarItem(
//                        selected = isSelected,
//                        onClick = { appState.navigateToTopLevelDestination(route) },
//                        icon = {
//                            if (isSelected) {
//                                Icon(imageVector = route.selectedIcon, contentDescription = null)
//                            } else {
//                                Icon(imageVector = route.unselectedIcon, contentDescription = null)
//                            }
//                        },
//                    )
//                }
//            }
//        },
//        floatingActionButton = {
//            Button(onClick = {}) {
//                Text("FAB")
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
//    ) { innerPadding ->
    FoodMeNavHost(
        appState = appState,
        startDestination = startDestination,
    )
//    }
}
