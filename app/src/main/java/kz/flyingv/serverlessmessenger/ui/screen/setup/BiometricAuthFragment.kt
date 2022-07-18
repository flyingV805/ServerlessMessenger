package kz.flyingv.serverlessmessenger.ui.screen.setup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kz.flyingv.serverlessmessenger.R

@Composable
fun BiometricAuthFragment() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("chating.json"))

    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition,
            modifier = Modifier.fillMaxWidth(0.6f).wrapContentHeight(),
            restartOnPlay = true,
            iterations = 1
        )
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {
            }
        ) {
            Icon(painter = painterResource(id = R.drawable.googleg_standard_color_18), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Sign in with Google", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}