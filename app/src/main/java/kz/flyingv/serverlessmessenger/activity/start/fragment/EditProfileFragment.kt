package kz.flyingv.serverlessmessenger.activity.start.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.activity.start.viewmodel.StartViewModel
import kz.flyingv.serverlessmessenger.databinding.FragmentStartEditProfileBinding

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

        binding.doneEdit.setOnClickListener {
            it.findNavController().navigate(R.id.toSetupDone)
        }

    }
}