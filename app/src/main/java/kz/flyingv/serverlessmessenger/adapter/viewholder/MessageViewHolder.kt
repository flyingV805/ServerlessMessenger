package kz.flyingv.serverlessmessenger.adapter.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.model.Message

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val text = view.findViewById<AppCompatTextView>(R.id.content)

    fun bind(message: Message){
        text.text = message.text
    }

}