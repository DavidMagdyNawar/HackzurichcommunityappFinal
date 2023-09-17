package de.davidriad.ouchcouch.events.ui

import com.davidriad.hackzurichcommunityapp.R

sealed class NavigationItem(var title:String, var icon:Int, var screen_route:String){

    object Post : NavigationItem("Home", R.drawable.ic_home,"home")
    object Inbox: NavigationItem("Inbox",R.drawable.ic_inbox,"inbox")
    object Calendar: NavigationItem("Calendar",R.drawable.ic_calendar,"calendar")
    object Profile: NavigationItem("Profile", R.drawable.ic_profile,"profile")
    object AddPost: NavigationItem("AddPost", R.drawable.ic_profile,"addPost")


}