package com.davidriad.hackzurichcommunityapp.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidriad.hackzurichcommunityapp.posts.data.Post
import com.davidriad.hackzurichcommunityapp.posts.remote.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class PostViewModel(private val repository: PostRepository) : ViewModel() {

    lateinit var _posts: Flow<List<Post>>
    val posts: Flow<List<Post>>
        get() = _posts

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _posts = repository.getPosts()

            } catch (e: Exception) {

            }
        }
    }
}