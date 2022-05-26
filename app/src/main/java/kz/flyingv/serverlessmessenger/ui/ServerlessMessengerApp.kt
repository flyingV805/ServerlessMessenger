package kz.flyingv.serverlessmessenger.ui

import android.os.Bundle
import android.util.Log
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
import com.google.firebase.auth.FirebaseAuth
import kz.flyingv.serverlessmessenger.ui.screen.chatlist.ChatListScreen
import kz.flyingv.serverlessmessenger.ui.screen.chatscreen.ChatScreen
import kz.flyingv.serverlessmessenger.ui.screen.setup.AuthMethodFragment
import kz.flyingv.serverlessmessenger.ui.screen.setup.WelcomeFragment
import kz.flyingv.serverlessmessenger.ui.theme.ServerlessMessengerTheme
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ServerlessMessengerApp : ComponentActivity(), KoinComponent {

    private val firebaseAuth: FirebaseAuth by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUser = firebaseAuth.currentUser
        val isAuthorized = firebaseAuth.currentUser != null
        Log.d("currentUser", currentUser.toString())
        Log.d("isAuthorized", isAuthorized.toString())

        setContent {
            ServerlessMessengerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainHost(firebaseAuth.currentUser != null)
                }
            }
        }
    }
}

@Composable
fun MainHost(isAuthorized: Boolean){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if(!isAuthorized) "setup" else "chat"
    ) {
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
        MainHost(false)
    }
}