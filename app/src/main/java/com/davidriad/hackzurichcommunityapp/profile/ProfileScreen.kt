package com.davidriad.hackzurichcommunityapp.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davidriad.hackzurichcommunityapp.R


@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
    // TODO: Load user data from Firebase and use it to populate the profile
    val user = viewModel.profile.collectAsState(initial = UserProfile()).value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display the user's image and name
        ProfileHeader(user)

        // Display the introduction about yourself
        IntroductionSection(user.introduction)

        // Display the list of interests
        InterestsSection(user.interests)

        // Display the availability status
        AvailabilityStatus(user.availabilityStatus)
    }
}

@Composable
fun ProfileHeader(user: UserProfile) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Display user image
        Image(
            painter = painterResource(id = R.drawable.profile_image), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        // Display user name
        Text(
            text = user.name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun IntroductionSection(introduction: String) {
    Text(
        text = introduction,
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun InterestsSection(interests: List<String>) {
    Text(
        text = "Interests:",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.padding(top = 16.dp)
    )

    interests.forEach { interest ->
        Text(
            text = "• $interest",
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun AvailabilityStatus(availabilityStatus: String) {
    Text(
        text = "Team matching availability:\r\n $availabilityStatus",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}
