package kz.flyingv.serverlessmessenger.ui.screen.companions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kz.flyingv.serverlessmessenger.domain.repository.ChatsRepository
import kz.flyingv.serverlessmessenger.domain.repository.CompanionsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CompanionsViewModel: ViewModel(), KoinComponent {

    private val companionsRepository: CompanionsRepository by inject()
    private val chatsRepository: ChatsRepository by inject()

    init {
        viewModelScope.launch(Dispatchers.IO){
            companionsRepository.testInit()
        }
    }

    val screenStateFlow: StateFlow<CompanionsState> = combine(
        companionsRepository.getAllCompanions()
    ){
        CompanionsState(it[0])
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialState())

    fun makeAction(action: CompanionsAction){
        when(action){
            is CompanionsAction.StartChat -> {
                viewModelScope.launch(Dispatchers.IO){
                    chatsRepository.startChat(action.companion)
                }
            }
        }
    }

    private fun initialState(): CompanionsState = CompanionsState(emptyList())

}