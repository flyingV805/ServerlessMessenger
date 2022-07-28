package kz.flyingv.serverlessmessenger.ui.screen.chatlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kz.flyingv.serverlessmessenger.data.model.ChatInfo
import kz.flyingv.serverlessmessenger.domain.repository.ChatsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChatListViewModel: ViewModel(), KoinComponent {

    private val chatsRepository: ChatsRepository by inject()

    val screenStateFlow: StateFlow<ChatListState> = combine(chatsRepository.getAllActiveWithInfo()){
        ChatListState(it[0])
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialState())

    private fun initialState(): ChatListState {
        return ChatListState(emptyList())
    }

}