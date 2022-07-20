package kz.flyingv.serverlessmessenger.ui.screen.setup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel.AuthorizeViewModel

@Composable
fun BiometricAuthFragment(navController: NavController, viewModel: AuthorizeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("biometricauth.json"))

    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ){
            LottieAnimation(
                composition,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(0.6f),
                restartOnPlay = true,
                iterations = 1
            )
        }
        Spacer(modifier = Modifier.height(IntrinsicSize.Max))
        Text("Secure app opening", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {
                navController.navigate("setupComplete")
            }
        ) {
            Icon(painter = painterResource(id = R.drawable.googleg_standard_color_18), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Enable", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {
                navController.navigate("setupComplete")
            }
        ) {
            Icon(painter = painterResource(id = R.drawable.googleg_standard_color_18), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Don't Enable", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}