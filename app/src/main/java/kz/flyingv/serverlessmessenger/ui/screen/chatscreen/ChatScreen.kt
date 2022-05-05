package kz.flyingv.serverlessmessenger.ui.screen.chatscreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ChatScreen(navController: NavController, chatId: String?, viewMode: ChatScreenViewModel = viewModel()) {

    Text("chat id $chatId")

}