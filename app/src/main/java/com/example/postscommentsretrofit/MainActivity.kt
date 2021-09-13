package com.example.postscommentsretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postscommentsretrofit.Comments.CommentsActivity
import com.example.postscommentsretrofit.Posts.PostsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        post_btn.setOnClickListener {

            val postIntent=Intent(this, PostsActivity::class.java)
            startActivity(postIntent)

        }
        comment_btn.setOnClickListener {

            val commentIntent=Intent(this, CommentsActivity::class.java)
            startActivity(commentIntent)

        }
    }
}