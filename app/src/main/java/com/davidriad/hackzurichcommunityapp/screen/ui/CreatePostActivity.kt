package com.davidriad.hackzurichcommunityapp.screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavController
import com.davidriad.hackzurichcommunityapp.posts.data.Post
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.max

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreatePostActivity(

    navController: NavController
) {
    var onAddPostClick: (String) -> Unit
    var onBackClick: () -> Unit
    var text by remember { mutableStateOf("") }
    lateinit var post: Post
    val database = FirebaseDatabase.getInstance()
    val postsRef = database.getReference("posts")
    val selectedTopics = remember { mutableStateListOf((String())) }
    val topics = listOf(
        "Sustainability",
        "Blockchain",
        "Software Engineering",
        "Smart Cities",
        "AI",
        "ML",
        "Marketing",
        "Firmware",
        "GNSS",
        "LIDAR",
        "WEB 3",
        "Crypto technology",
        "Data Analysis"
    )

    onAddPostClick = { postContent ->
        navController.popBackStack()

        if (postContent.isNotBlank()) {
            text = postContent


            val newPostId = (0..100000).random()
            post = Post()
            post.authorImage = ""
            post.id = newPostId
            post.body = text
            post.authorName = "David"
            post.isLiked = false
            post.comments = emptyList()
            postsRef.child(post.id.toString()).setValue(post)

            text = ""


        }
    }
    onBackClick = {
        navController.popBackStack()

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {


        OutlinedTextField(
            value = text,
            minLines = 8,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Enter your post") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(modifier = Modifier.padding(8.dp)) {

            topics.forEach { topic ->
                TopicItem(
                    topic = topic,
                    isSelected = selectedTopics.contains(topic),
                    onTopicChecked = { isChecked ->
                        if (isChecked) {
                            selectedTopics.add(topic)
                        } else {
                            selectedTopics.remove(topic)
                        }
                    }
                )
            }

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (text.isNotEmpty()) {
                        onAddPostClick(text)
                        text = ""
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Submit")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = onBackClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("Back")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TopicItem(topic: String, isSelected: Boolean, onTopicChecked: (Boolean) -> Unit) {

    Spacer(modifier = Modifier.width(4.dp)) // Adjust spacing as needed

    Card(
        modifier = Modifier
            .clickable { onTopicChecked(!isSelected) }
            .padding(4.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = if (isSelected) Color.Green else Color.White,
        contentColor = if (isSelected) Color.White else Color.Black
    ) {
        Text(modifier = Modifier.padding(8.dp), text = topic)
    }

    Spacer(modifier = Modifier.width(4.dp))

}
