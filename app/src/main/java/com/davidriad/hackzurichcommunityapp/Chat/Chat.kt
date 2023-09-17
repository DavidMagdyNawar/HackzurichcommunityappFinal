package com.davidriad.hackzurichcommunityapp.Chat

data class Chat(
    val senderName: String,
    val senderImage: String,
    val lastMessage: String,
) {
    constructor() : this("", "", "")
}