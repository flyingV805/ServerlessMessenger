package kz.flyingv.serverlessmessenger.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import kz.flyingv.serverlessmessenger.ui.screen.chatlist.ChatListScreen
import kz.flyingv.serverlessmessenger.ui.screen.chatscreen.ChatScreen
import kz.flyingv.serverlessmessenger.ui.screen.setup.AuthMethodFragment
import kz.flyingv.serverlessmessenger.ui.screen.setup.WelcomeFragment
import kz.flyingv.serverlessmessenger.ui.theme.ServerlessMessengerTheme

class ServerlessMessengerApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ServerlessMessengerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainHost()
                }
            }
        }
    }
}

@Composable
fun MainHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "setup") {
        setupGraph(navController)
        chatGraph(navController)
    }

}

fun NavGraphBuilder.setupGraph(navController: NavController){
    navigation(startDestination = "welcome", route = "setup") {
        composable("welcome") { WelcomeFragment(navController) }
        composable("authMethod") { AuthMethodFragment(navController) }
    }
}

fun NavGraphBuilder.chatGraph(navController: NavController){
    navigation(startDestination = "chatList", route = "chat") {
        composable("chatList") { ChatListScreen(navController) }
        composable("chat/{chatId}") { entry ->
            ChatScreen(
                navController,
                entry.arguments?.getString("chatId")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ServerlessMessengerTheme {
        MainHost()
    }
}