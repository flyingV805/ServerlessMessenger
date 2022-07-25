package kz.flyingv.serverlessmessenger.ui.screen.chatlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.Companion
import kz.flyingv.serverlessmessenger.data.model.LastMessage

class ChatListViewModel: ViewModel() {

    private val _activeChats: MutableStateFlow<List<Chat>> = MutableStateFlow(
        listOf(
            Chat(
                1,
                Companion("https://static.wikia.nocookie.net/uncharted-game/images/3/34/Image.png/revision/latest?cb=20190305165221&path-prefix=ru", "Victor Sullivan", "@sully", ""),
                LastMessage("This girl is on fireeeee", System.currentTimeMillis())
            ),
            Chat(
                1,
                Companion("https://static.wikia.nocookie.net/uncharted/images/9/9d/Nathan_Drake_from_A_Thief%27s_End.png/revision/latest?cb=20180521172750", "Nathan Drake", "@sigparvismagna", ""),
                LastMessage("You will not believe this", System.currentTimeMillis())
            ),
            Chat(
                1,
                Companion("https://static.wikia.nocookie.net/uncharted-game/images/0/08/ChloeFrazer-UTLL.png/revision/latest?cb=20190305171141&path-prefix=ru", "Chloe Frazer", "@chlochlo", ""),
                LastMessage("How bout a dinner?", System.currentTimeMillis())
            ),
            Chat(
                1,
                Companion("https://static.wikia.nocookie.net/uncharted-game/images/0/02/Uncharted-4-elena-fisher-0.jpg/revision/latest?cb=20190305170919&path-prefix=ru", "Elena Fisher", "@thee", ""),
                LastMessage("Hey!", System.currentTimeMillis())
            )
        )
    )

    val screenStateFlow: StateFlow<ChatListState> = _activeChats.map { ChatListState(it) }.stateIn(viewModelScope, SharingStarted.Lazily, initialState())

    private fun initialState(): ChatListState {
        return ChatListState(emptyList())
    }

}