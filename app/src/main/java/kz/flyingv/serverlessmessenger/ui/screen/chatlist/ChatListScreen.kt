package kz.flyingv.serverlessmessenger.ui.screen.chatlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.ChatInfo

@Composable
fun ChatListScreen(navController: NavController, viewModel: ChatListViewModel = viewModel()) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    val state = viewModel.screenStateFlow.collectAsState().value

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Serverless Messenger") },
                backgroundColor = colorResource(id = R.color.purple_700),
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_qr_code_24), contentDescription = null)
                    }
                }
            )
        },
        content = {
            ChatList(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(it),
                chats = state.chats,
                chatSelected = { chat ->
                    navController.navigate("chat/${chat.chatId}")
                }
            )
        },
        drawerContent = {

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("companions")
            }) {Icon(Icons.Filled.Add, "")}
        }
    )


}

@Composable
fun ChatList(modifier: Modifier, chats: List<ChatInfo>, chatSelected: (chat: Chat)-> Unit?){
    LazyColumn(modifier = modifier){

        if(chats.isEmpty()){
            item {
                val composition by rememberLottieComposition(LottieCompositionSpec.Asset("emptychats.json"))
                Column(
                    modifier = Modifier.wrapContentHeight().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.height(36.dp))
                    Text(
                        text = "Oops, it is so empty in your inbox ...",
                        style = typography.h6
                    )
                    LottieAnimation(
                        composition,
                        modifier = Modifier.fillMaxWidth().height(256.dp),
                        contentScale = ContentScale.FillHeight,
                        restartOnPlay = false,
                        iterations = 1
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Start a conversation!",
                        style = typography.h6
                    )
                }
            }
        }

        items(
            count = chats.size,
            itemContent = {
                ChatListItem(chats[it], chatSelected)
            }
        )
    }
}

@Composable
fun ChatListItem(chat: ChatInfo, chatSelected: (chat: Chat)-> Unit?){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clickable {
                chatSelected(chat.chat)
            },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .background(colorResource(id = R.color.purple_200), CircleShape),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = rememberAsyncImagePainter(chat.companion.firstOrNull()?.photoUrl ?: ""),
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                //companion avatar
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(Modifier.weight(1f)) {
                Text(text = chat.companion.firstOrNull()?.displayName ?: "", style = typography.h6, maxLines = 1)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "chat.lastMessage.message", style = typography.body1, maxLines = 1)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "16:32", style = typography.caption, maxLines = 1)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}