package com.davidriad.hackzurichcommunityapp.profile

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class ProfileRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val meRef: DatabaseReference = database.getReference("users/davidID")

    fun getPosts(): Flow<UserProfile> {
        val userProfile = MutableStateFlow<UserProfile>(UserProfile())


        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dataSnapshot = meRef.get().await()


                val me = dataSnapshot.getValue(UserProfile::class.java).let {
                    userProfile.emit(it!!)
                }


            } catch (e: Exception) {

            }
        }

        return userProfile
    }

}



