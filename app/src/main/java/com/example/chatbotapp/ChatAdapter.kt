package com.example.chatbotapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messages: List<ChatMessage>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val currentMessage = messages[position]
        holder.messageTextView.text = currentMessage.message

        // Align message to left (bot) or right (user)
        val params = holder.messageTextView.layoutParams as ViewGroup.MarginLayoutParams
        if (currentMessage.isUser) {
            params.marginStart = 50
            params.marginEnd = 0
            holder.messageTextView.setBackgroundResource(android.R.color.holo_blue_light)
        } else {
            params.marginStart = 0
            params.marginEnd = 50
            holder.messageTextView.setBackgroundResource(R.drawable.message_background)
        }
        holder.messageTextView.layoutParams = params
    }

    override fun getItemCount(): Int = messages.size
}
