package kz.flyingv.serverlessmessenger.ui.screen.chatscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kz.flyingv.serverlessmessenger.R

@Composable
fun ChatScreen(navController: NavController, chatId: String?, viewModel: ChatScreenViewModel = viewModel()) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row() {
                        Image(
                            painter = rememberAsyncImagePainter("https://static.wikia.nocookie.net/uncharted-game/images/3/34/Image.png/revision/latest?cb=20190305165221&path-prefix=ru"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column() {
                            Text("Victor Sullivan")
                            Text("@sully")

                        }
                    }
                },
                backgroundColor = colorResource(id = R.color.purple_700),
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24), contentDescription = null)
                    }
                },
            )
        },
        content = {
            ChatView(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(it))
        }
    )

}

@Composable
fun ChatView(modifier: Modifier){

}