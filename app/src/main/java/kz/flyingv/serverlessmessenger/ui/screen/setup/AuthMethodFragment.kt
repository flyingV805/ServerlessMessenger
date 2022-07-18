package kz.flyingv.serverlessmessenger.ui.screen.setup

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.ui.screen.setup.viewmodel.AuthorizeViewModel

@Composable
fun AuthMethodFragment(navController: NavController, viewModel: AuthorizeViewModel = viewModel()) {

    val context = LocalContext.current
    val screenState = viewModel.authScreenState.collectAsState().value
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("person.json"))

    val googleAuthLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            viewModel.signInGoogleAuth(credential)
        } catch (e: ApiException) {

            Log.w("TAG", "Google sign in failed", e)
        }
    }

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
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken("token")
                    .requestEmail()
                    .build()
                val googleSignInClient = GoogleSignIn.getClient(context, gso)
                googleAuthLauncher.launch(googleSignInClient.signInIntent)
            }
        ) {
            Icon(painter = painterResource(id = R.drawable.googleg_standard_color_18), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text( modifier = Modifier.fillMaxWidth(), text = "Sign in with Google", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))/*
        Button(
            modifier = Modifier.height(56.dp).fillMaxWidth(0.6f),
            onClick = {
            }
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
        }*/
    }

}