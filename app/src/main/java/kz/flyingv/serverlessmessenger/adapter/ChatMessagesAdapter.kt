package kz.flyingv.serverlessmessenger.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.adapter.viewholder.MessageViewHolder
import kz.flyingv.serverlessmessenger.model.Message

class ChatMessagesAdapter(options: FirebaseRecyclerOptions<Message>): FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_incoming_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int, model: Message) {
        holder.bind(model)
    }


}