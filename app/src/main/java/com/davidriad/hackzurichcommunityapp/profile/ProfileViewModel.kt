package com.davidriad.hackzurichcommunityapp.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidriad.hackzurichcommunityapp.posts.data.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {

    private lateinit var _profile: Flow<UserProfile>
    val profile: Flow<UserProfile>
        get() = _profile

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _profile = repository.getPosts()

            } catch (e: Exception) {

            }
        }
    }
}