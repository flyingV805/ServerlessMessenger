package kz.flyingv.serverlessmessenger.ui.activity.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.databinding.FragmentMainChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentMainChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainChatBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setLogo(R.drawable.ic_baseline_person_24)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(true)


    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause", "adapter.startListening()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "adapter.stopListening()")
    }
}