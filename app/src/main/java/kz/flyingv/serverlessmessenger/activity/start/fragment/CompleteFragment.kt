package kz.flyingv.serverlessmessenger.activity.start.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.activity.main.MainActivity
import kz.flyingv.serverlessmessenger.databinding.FragmentStartCompleteBinding

class CompleteFragment : Fragment() {

    private lateinit var binding: FragmentStartCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartCompleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startUsing.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }

    }

}