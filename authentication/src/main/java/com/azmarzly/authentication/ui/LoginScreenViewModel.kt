package com.azmarzly.authentication.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.azmarzly.authentication.AuthenticationRepository
import com.azmarzly.core.Resource
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthenticationRepository,
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    val isEmailValid: StateFlow<Boolean> =
        snapshotFlow { email }
            .debounce(300)
            .mapLatest { it.isEmpty() || true } // replace true with email validator
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = true
            )

    val isSignInEnabled: StateFlow<Boolean> =
        combine(
            snapshotFlow { email },
            snapshotFlow { password },
            isEmailValid
        ) { email, password, emailValid ->
            email.isNotEmpty()
                    && password.isNotEmpty()
                    && emailValid
        }
            .debounce(300)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = false
            )

    fun updateEmail(input: String) {
        email = input
    }

    fun updatePassword(input: String) {
        password = input
    }

    fun onSignInWithGoogleClicked(credential: Credential) {
        viewModelScope.launch {
            authRepository.signInWithGoogle(credential).collect {
                when (it) {
                    Resource.Loading -> TODO()
                    is Resource.Error -> TODO()
                    is Resource.Success -> TODO()
                    Resource.EmptyState -> TODO()
                }
            }
        }

    }
}