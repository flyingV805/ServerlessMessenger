package kz.flyingv.serverlessmessenger.activity.start.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.activity.start.viewmodel.StartViewModel
import kz.flyingv.serverlessmessenger.databinding.FragmentStartGoogleAuthBinding
import kz.flyingv.serverlessmessenger.databinding.FragmentStartWelcomeBinding

class GoogleAuthFragment : Fragment() {

    private lateinit var binding: FragmentStartGoogleAuthBinding
    private val viewModel: StartViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStartGoogleAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInGoogle.setOnClickListener {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
            val signInIntent = googleSignInClient.signInIntent
            resultLauncher.launch(signInIntent)

        }

    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        binding.signInGoogle.findNavController().navigate(R.id.toEditProfile)
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            // Google Sign In was successful, authenticate with Firebase
            val account = task.getResult(ApiException::class.java)!!
            viewModel.authUser(
                uniqueId = account.id!!,
                email = account.email!!,
                name = account.displayName!!,
                photoUrl = account.photoUrl!!.toString()
            )
            Log.d("GOOGLE", "firebaseAuthWithGoogle: $account")
            Log.d("GOOGLE", "firebaseAuthWithGoogle:" + account.id)
            //firebaseAuthWithGoogle(account.idToken!!)
        } catch (e: ApiException) {
            e.printStackTrace()
            // Google Sign In failed, update UI appropriately
            Log.w("GOOGLE", "Google sign in failed", e.cause)
        }
    }

}