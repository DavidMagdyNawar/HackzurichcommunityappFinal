package com.davidriad.hackzurichcommunityapp.inbox

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
import com.davidriad.hackzurichcommunityapp.Chat.ChatCardView
import com.davidriad.hackzurichcommunityapp.Chat.ChatViewModel
import com.davidriad.hackzurichcommunityapp.R


@Composable
fun ChatScreen(viewModel: ChatViewModel, navController: NavController) {
    val list = viewModel.chats.collectAsState(initial = emptyList())


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(list.value) { chat ->
                ChatCardView(
                    imageUrl = R.drawable.background,
                    senderName = chat.senderName,
                    lastMessage = chat.lastMessage
                )
            }
        }


    }
}
