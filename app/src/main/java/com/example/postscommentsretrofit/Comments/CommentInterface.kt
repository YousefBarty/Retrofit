package com.example.postscommentsretrofit.Comments

import com.example.postscommentsretrofit.Posts.PostsItem
import retrofit2.Call
import retrofit2.http.GET

interface CommentInterface {

    @GET("comments")
    fun getData(): Call<List<CommentsItem>>
}