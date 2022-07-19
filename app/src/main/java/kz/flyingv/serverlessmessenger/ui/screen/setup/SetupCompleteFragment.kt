package kz.flyingv.serverlessmessenger.ui.screen.setup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SetupCompleteFragment(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("success.json"))
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(0.6f),
            restartOnPlay = true,
            iterations = 3
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Welcome to ServerlessMessenger", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.6f),
            onClick = {

            }
        ) {
            Text("START")
        }
    }
}