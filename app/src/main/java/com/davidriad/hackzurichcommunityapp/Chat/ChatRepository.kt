package com.davidriad.hackzurichcommunityapp.Chat

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class ChatRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val chatRefs: DatabaseReference = database.getReference("chats")

    fun getPosts(): Flow<List<Chat>> {
        val chatFlow = MutableStateFlow<List<Chat>>(emptyList())


        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dataSnapshot = chatRefs.get().await()
                val chatList = mutableListOf<Chat>()

                for (chatSnapshot in dataSnapshot.children) {
                    val chat = chatSnapshot.getValue(Chat::class.java)
                    chat?.let { chatList.add(it) }
                }

                chatFlow.emit(chatList)
            } catch (e: Exception) {

            }
        }

        return chatFlow
    }

}



