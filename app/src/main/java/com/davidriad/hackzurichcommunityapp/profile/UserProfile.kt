package com.davidriad.hackzurichcommunityapp.profile

data class UserProfile(
    val userId: String,
    val name: String,
    val introduction: String,
    val interests: List<String>,
    val availabilityStatus: String,
    val imageUrl: String
) {
    constructor() : this("", "", "", listOf(), "", "")
}