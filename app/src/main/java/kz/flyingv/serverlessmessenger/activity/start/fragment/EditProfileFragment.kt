package kz.flyingv.serverlessmessenger.activity.start.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.onEach
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.activity.start.viewmodel.StartViewModel
import kz.flyingv.serverlessmessenger.databinding.FragmentStartEditProfileBinding
import kz.flyingv.serverlessmessenger.utils.launchWhenStarted

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentStartEditProfileBinding
    private val viewModel: StartViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userProfile.onEach {
            Log.d("user profile", it.toString())
            it?.let { userProfile ->
                Glide.with(this).load(userProfile.photoUrl).into(binding.userAvatar)
                binding.nickname.setText(userProfile.nickname)
                binding.displayName.setText(userProfile.displayName)
            }
        }.launchWhenStarted(lifecycleScope)

        binding.doneEdit.setOnClickListener {
            it.findNavController().navigate(R.id.toSetupDone)
        }

    }
}