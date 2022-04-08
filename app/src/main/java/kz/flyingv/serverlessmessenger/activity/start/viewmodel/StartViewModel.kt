package kz.flyingv.serverlessmessenger.activity.start.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kz.flyingv.serverlessmessenger.model.AppUser
import kz.flyingv.serverlessmessenger.model.UserProfile
import kz.flyingv.serverlessmessenger.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StartViewModel: ViewModel(), KoinComponent {

    private val firebaseAuth: FirebaseAuth by inject()
    private val userRepository: UserRepository by inject()

    private val _userProfile = MutableStateFlow<UserProfile?>(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile.stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun authUser(idToken: String, uniqueId: String, email: String, name: String, photoUrl: String){
        viewModelScope.launch(Dispatchers.IO){
            val nicknameFromEmail = email.split("@").getOrNull(0) ?: ""
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
                if(it.isSuccessful){

                }else{

                }
            }
            _userProfile.emit(UserProfile(photoUrl = photoUrl, displayName = name, nickname = nicknameFromEmail))
            userRepository.setAppUser(
                AppUser(
                    userId = uniqueId,
                    userNickname = nicknameFromEmail,
                    userName = name,
                    userPhotoUrl = photoUrl
                )
            )
        }
    }

}