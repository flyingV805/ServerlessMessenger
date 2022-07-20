package kz.flyingv.serverlessmessenger.ui.screen.setup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel.AuthorizeViewModel

@Composable
fun SetupProfileFragment(navController: NavController, viewModel: AuthorizeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_send_24),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 16.dp, end = 16.dp),
            value = "",
            singleLine = true,
            isError = false,
            leadingIcon = { Icon(painterResource(id = R.drawable.ic_baseline_alternate_email_24), contentDescription = null)},
            onValueChange = {
                //viewModel.makeAction(NewReminderAction.UpdateName(it))
            },
            placeholder = { Text("Your nickname") },
            keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Words)
        )
        AnimatedVisibility(visible = false) {
            Text(
                text = "You need it, trust me",
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 16.dp, end = 16.dp),
            value = "",
            singleLine = true,
            isError = false,
            leadingIcon = { Icon(painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = null)},
            onValueChange = {
                //viewModel.makeAction(NewReminderAction.UpdateName(it))
            },
            placeholder = { Text("Your name") },
            keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Words)
        )
        AnimatedVisibility(visible = false) {
            Text(
                text = "You need to name it, trust me",
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.6f),
            onClick = {
                navController.navigate("biometricOpen")
            }
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Save",
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
    }

}