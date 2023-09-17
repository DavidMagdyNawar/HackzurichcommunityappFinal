package com.davidriad.hackzurichcommunityapp.posts.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidriad.hackzurichcommunityapp.R
@Composable
fun PostCardView(
    imageUrl: Int,
    authorName: String,
    postBody: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Set the background color of the Card
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Image(
                    painter = painterResource(id = imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(30.dp)) // Rounded image
                )

                // Spacer between image and text
                Spacer(modifier = Modifier.width(16.dp))

                // Author name and post body
                Column {
                    Text(
                        text = authorName,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = postBody,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PostCardViewPreview() {
    PostCardView(
        imageUrl = R.drawable.background,
        authorName = "John Doe",
        postBody = "This is the body of the post. It can be a longer text as well."
    )
}
