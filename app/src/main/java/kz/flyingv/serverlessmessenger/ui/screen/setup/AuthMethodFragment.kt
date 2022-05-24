package kz.flyingv.serverlessmessenger.ui.screen.setup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel.AuthorizeViewModel

@Composable
fun AuthMethodFragment(navController: NavController, viewModel: AuthorizeViewModel = viewModel()) {

    val screenState = viewModel.authScreenState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {  }
        ) {
            Icon(painter = painterResource(id = R.drawable.googleg_standard_color_18), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Sign in with Google", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {  }
        ) {
            Icon(Icons.Filled.Email, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Sign in with Email", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {  }
        ) {
            Icon(Icons.Filled.Phone, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Sign in with phone", textAlign = TextAlign.Center)
        }
    }

}