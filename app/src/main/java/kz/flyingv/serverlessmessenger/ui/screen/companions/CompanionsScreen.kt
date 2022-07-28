package kz.flyingv.serverlessmessenger.ui.screen.companions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.data.model.Companion

@Composable
fun CompanionsScreen(navController: NavController, viewModel: CompanionsViewModel = viewModel()) {

    //val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    val state = viewModel.screenStateFlow.collectAsState().value

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("My Dudes...") },
                backgroundColor = colorResource(id = R.color.purple_700),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ){
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
        content = {
            CompanionsList(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(it),
                companions = state.companions,
                companionSelected = { companion ->
                    viewModel.makeAction(CompanionsAction.StartChat(companion))
                    navController.navigateUp()
                    println()
                }
            )
        },
    )

}

@Composable
fun CompanionsList(modifier: Modifier, companions: List<Companion>, companionSelected: (companion: Companion)-> Unit?){
    LazyColumn(
        modifier = modifier,
        content = {
            item {
                ScanQR()
            }
            item{
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    elevation = 8.dp
                ) {
                    Text(
                        text = "Your contacts",
                        style = MaterialTheme.typography.h6,
                        maxLines = 1
                    )
                }
            }
            items(
                companions.size,
                itemContent = {
                    CompanionsListItem(companions[it], companionSelected)
                },
            )
        }
    )
}

@Composable
fun CompanionsListItem(companion: Companion, companionSelected: (companion: Companion)-> Unit?){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                companionSelected(companion)
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
                    painter = rememberAsyncImagePainter(companion.photoUrl),
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
                Text(text = companion.displayName, style = MaterialTheme.typography.h6, maxLines = 1)
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ScanQR(){
    Card(
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {},
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.purple_200)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.width(56.dp).height(56.dp).background(colorResource(id = R.color.purple_200), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_qr_code_24),
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
                Text(
                    text = "Scan companion QR",
                    style = MaterialTheme.typography.h6,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}
