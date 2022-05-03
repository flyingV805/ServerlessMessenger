package kz.flyingv.serverlessmessenger.ui.activity.start.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.databinding.FragmentStartWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentStartWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.start.setOnClickListener {
            it.findNavController().navigate(R.id.toSignIn)
        }

    }
}