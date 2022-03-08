package kz.flyingv.serverlessmessenger.adapter.observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import kz.flyingv.serverlessmessenger.adapter.ChatMessagesAdapter

class ScrollToBottomObserver (
    private val recycler: RecyclerView,
    private val adapter: ChatMessagesAdapter,
    private val manager: LinearLayoutManager
) : AdapterDataObserver() {

    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        super.onItemRangeInserted(positionStart, itemCount)
        val count = adapter.itemCount
        val lastVisiblePosition = manager.findLastCompletelyVisibleItemPosition()
        val loading = lastVisiblePosition == -1
        val atBottom = positionStart >= count - 1 && lastVisiblePosition == positionStart - 1
        if (loading || atBottom) {
            recycler.scrollToPosition(positionStart)
        }
    }

}