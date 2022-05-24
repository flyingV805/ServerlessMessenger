package kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class AuthorizeViewModel: ViewModel() {

    private val _authScreenState: MutableStateFlow<AuthViewState> = MutableStateFlow(AuthViewState.Loading)

    val authScreenState = _authScreenState.stateIn(viewModelScope, SharingStarted.Lazily, AuthViewState.Loading)

}

sealed class AuthViewState {
    object Loading: AuthViewState()
    object Success: AuthViewState()
    object Error: AuthViewState()
}