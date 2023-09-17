package com.davidriad.hackzurichcommunityapp.posts.remote

import com.davidriad.hackzurichcommunityapp.posts.data.Post
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PostRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val postsRef: DatabaseReference = database.getReference("posts")

    fun getPosts(): Flow<List<Post>> {
        val postsFlow = MutableStateFlow<List<Post>>(emptyList())


        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dataSnapshot = postsRef.get().await()
                val postList = mutableListOf<Post>()

                for (postSnapshot in dataSnapshot.children) {
                    val post = postSnapshot.getValue(Post::class.java)
                    post?.let { postList.add(it) }
                }

                postsFlow.emit(postList)
            } catch (e: Exception) {

            }
        }

        return postsFlow
    }

}



