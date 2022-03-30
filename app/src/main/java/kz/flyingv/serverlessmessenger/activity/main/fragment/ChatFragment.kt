package kz.flyingv.serverlessmessenger.activity.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.adapter.ChatMessagesAdapter
import kz.flyingv.serverlessmessenger.adapter.observer.ScrollToBottomObserver
import kz.flyingv.serverlessmessenger.databinding.FragmentChatBinding
import kz.flyingv.serverlessmessenger.model.Message

class ChatFragment : Fragment() {

    private lateinit var db: FirebaseDatabase
    private lateinit var binding: FragmentChatBinding
    private lateinit var adapter: ChatMessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.database("https://serverlessmessenger-default-rtdb.asia-southeast1.firebasedatabase.app")



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
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