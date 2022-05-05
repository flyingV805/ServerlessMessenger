package kz.flyingv.serverlessmessenger.ui.screen.chatlist

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ChatListScreen(navController: NavController, viewMode: ChatListViewModel = viewModel()) {

    val scope = rememberCoroutineScope()

    Scaffold(
        content = {
             Text("chat list")
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("chat/12345")
            }) {Icon(Icons.Filled.Add, "")}
        }
    )


}