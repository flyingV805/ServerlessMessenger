package kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.Exception

class AuthorizeViewModel: ViewModel(), KoinComponent {

    private val firebaseAuth: FirebaseAuth by inject()

    private val _authScreenState: MutableStateFlow<AuthViewState> = MutableStateFlow(AuthViewState.Loading)

    val authScreenState = _authScreenState.stateIn(viewModelScope, SharingStarted.Lazily, AuthViewState.Loading)

    fun signInGoogleAuth(credentials: AuthCredential) = viewModelScope.launch {
        try {
            firebaseAuth.signInWithCredential(credentials).await()
        }catch (e: Exception){
            e.printStackTrace()
        }

    }

}

sealed class AuthViewState {
    object Loading: AuthViewState()
    object Success: AuthViewState()
    object Error: AuthViewState()
}