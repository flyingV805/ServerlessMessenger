package kz.flyingv.serverlessmessenger.activity.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kz.flyingv.serverlessmessenger.adapter.ChatMessagesAdapter
import kz.flyingv.serverlessmessenger.databinding.FragmentChatBinding
import kz.flyingv.serverlessmessenger.model.Message

class ChatFragment : Fragment() {

    private lateinit var db: FirebaseDatabase
    private lateinit var binding: FragmentChatBinding
    private lateinit var adapter: ChatMessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.database("https://serverlessmessenger-default-rtdb.asia-southeast1.firebasedatabase.app")
        //db.reference.child("messages")


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val messagesRef = db.reference.child("messages")

        val options = FirebaseRecyclerOptions.Builder<Message>()
            .setQuery(messagesRef, Message::class.java)
            .build()

        db.reference.child("messages").get().addOnCompleteListener {
            Log.d("snapshot", it.result?.toString() ?: "")
        }

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.stackFromEnd = true

        adapter = ChatMessagesAdapter(options)

        binding.messagesView.layoutManager = layoutManager
        binding.messagesView.adapter = adapter

        binding.sendMessage.setOnClickListener {

            val friendlyMessage = Message(
                binding.newMessage.text.toString(),
                "",
                "",
                null
            )
            db.reference.child("messages").push().setValue(friendlyMessage)
            binding.newMessage.setText("")

            Log.d("count", adapter.itemCount.toString())
        }

    }

    override fun onPause() {
        super.onPause()
        adapter.stopListening()
        Log.d("onPause", "adapter.startListening()")
    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
        Log.d("onResume", "adapter.stopListening()")
    }
}