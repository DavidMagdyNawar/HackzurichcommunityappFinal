package com.davidriad.hackzurichcommunityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.davidriad.hackzurichcommunityapp.Chat.ChatRepository
import com.davidriad.hackzurichcommunityapp.Chat.ChatViewModel
import com.davidriad.hackzurichcommunityapp.posts.remote.PostRepository
import com.davidriad.hackzurichcommunityapp.posts.viewmodel.PostViewModel
import com.davidriad.hackzurichcommunityapp.profile.ProfileRepository
import com.davidriad.hackzurichcommunityapp.profile.ProfileViewModel
import com.davidriad.hackzurichcommunityapp.ui.theme.HackzurichCommunityAppTheme
import com.google.firebase.FirebaseApp
import de.davidriad.ouchcouch.events.ui.BottomNavigationBar
import de.davidriad.ouchcouch.events.ui.Navigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            HackzurichCommunityAppTheme() {
                MainScreen()

            }
        }
    }
}

@Composable
fun MainScreen() {

    val postRepository = PostRepository()
    val navController = rememberNavController()
    var postViewModel = PostViewModel(postRepository)

    val chatRepository = ChatRepository()
    var chatViewModel = ChatViewModel(chatRepository)

    val profileRepo = ProfileRepository()
    var profileViewModel = ProfileViewModel(profileRepo)

    Scaffold(
        topBar = { },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(
                    postViewModel = postViewModel,
                    chatViewModel = chatViewModel,
                    profileViewModel = profileViewModel,
                    navController = navController
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
