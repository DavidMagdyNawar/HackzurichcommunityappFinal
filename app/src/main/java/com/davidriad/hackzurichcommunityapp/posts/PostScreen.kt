package com.davidriad.hackzurichcommunityapp.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davidriad.hackzurichcommunityapp.R
import com.davidriad.hackzurichcommunityapp.posts.ui.PostCardView
import com.davidriad.hackzurichcommunityapp.posts.viewmodel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel, navController: NavController) {
    val list = viewModel.posts.collectAsState(initial = emptyList())


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // LazyColumn for displaying posts
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(list.value) { post ->
                PostCardView(
                    imageUrl = R.drawable.profile_image,
                    authorName = post.authorName,
                    postBody = post.body
                )
            }
        }

        FloatingActionButton(
            onClick = { navController.navigate("addPost") },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            shape = CircleShape
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }


    }
}
