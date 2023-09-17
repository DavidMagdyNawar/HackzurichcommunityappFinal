package com.davidriad.hackzurichcommunityapp.posts.data

data class Post(
    var id: Int,
    var title: String,
    var body: String,
    var authorName: String,
    var authorImage: String,
    var isLiked: Boolean,
    var comments: List<Comment> = emptyList()
) {
    constructor() : this(
        0, "", "",
        "", "", false
    )
}

data class Comment(
    val commentID: Int,
    val comment: String,
    val commentator: String,
    val commentatorPhoto: String,
) {
    constructor() : this(0, "", "", "")
}

data class PostObject(
    var postObject: Map<String, Post>
)