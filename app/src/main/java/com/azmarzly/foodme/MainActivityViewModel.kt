package com.azmarzly.foodme

import androidx.lifecycle.ViewModel
import com.azmarzly.authentication.AuthenticationRepository
import com.azmarzly.foodme.navigation.TopLevelRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    authenticationRepository: AuthenticationRepository,
) : ViewModel() {

    val startDestination: TopLevelRoute = if (authenticationRepository.isSignedIn()) {
        TopLevelRoute.HOME
    } else {
        TopLevelRoute.LOGIN
    }

}