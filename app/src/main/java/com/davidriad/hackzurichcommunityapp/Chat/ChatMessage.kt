package com.davidriad.hackzurichcommunityapp.Chat
data class ChatMessage(
    val messageId: String,
    val senderId: String,
    val text: String,
    val timestamp: Long
)

data class ChatUser(
    val userId: String,
    val name: String,
    val imageUrl: String
)