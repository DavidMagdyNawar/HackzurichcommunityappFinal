package com.davidriad.hackzurichcommunityapp.posts.remote

import com.davidriad.hackzurichcommunityapp.posts.data.PostObject
import retrofit2.http.GET

interface ApiService {
    @GET("posts.json")
    fun getPosts(): List<PostObject>
}