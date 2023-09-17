package com.davidriad.hackzurichcommunityapp.Chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ChatViewModel(private val repository: ChatRepository) : ViewModel() {

    lateinit var _chats: Flow<List<Chat>>
    val chats: Flow<List<Chat>>
        get() = _chats

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _chats = repository.getPosts()

            } catch (e: Exception) {

            }
        }
    }
}