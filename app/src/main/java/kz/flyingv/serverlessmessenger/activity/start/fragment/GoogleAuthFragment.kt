package kz.flyingv.serverlessmessenger.activity.start.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.databinding.FragmentStartGoogleAuthBinding
import kz.flyingv.serverlessmessenger.databinding.FragmentStartWelcomeBinding

class GoogleAuthFragment : Fragment() {

    private lateinit var binding: FragmentStartGoogleAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStartGoogleAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}