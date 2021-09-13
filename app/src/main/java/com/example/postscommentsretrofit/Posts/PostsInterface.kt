package com.example.postscommentsretrofit.Posts

import retrofit2.Call
import retrofit2.http.GET

interface PostsInterface {

    @GET("posts")
    fun getData():Call<List<PostsItem>>
}