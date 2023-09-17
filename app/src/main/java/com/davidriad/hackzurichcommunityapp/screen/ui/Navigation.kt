package de.davidriad.ouchcouch.events.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.davidriad.hackzurichcommunityapp.Chat.ChatViewModel
import com.davidriad.hackzurichcommunityapp.calendar.CalendarScreen
import com.davidriad.hackzurichcommunityapp.inbox.ChatScreen
import com.davidriad.hackzurichcommunityapp.posts.PostScreen
import com.davidriad.hackzurichcommunityapp.posts.viewmodel.PostViewModel
import com.davidriad.hackzurichcommunityapp.screen.ui.CreatePostActivity
import com.davidriad.hackzurichcommunityapp.profile.ProfileScreen
import com.davidriad.hackzurichcommunityapp.profile.ProfileViewModel

@Composable
fun Navigation(
    postViewModel: PostViewModel,
    chatViewModel: ChatViewModel,
    profileViewModel: ProfileViewModel,
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.Post.screen_route) {
        composable(NavigationItem.Post.screen_route) {
            PostScreen(viewModel = postViewModel, navController = navController)
        }
        composable(NavigationItem.Inbox.screen_route) {
            ChatScreen(viewModel = chatViewModel, navController)
        }
        composable(NavigationItem.Calendar.screen_route) {
            CalendarScreen()
        }
        composable(NavigationItem.Profile.screen_route) {
            ProfileScreen(viewModel = profileViewModel , navController)
        }
        composable(NavigationItem.AddPost.screen_route) {
            CreatePostActivity(navController = navController)
        }

    }
}
