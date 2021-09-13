package com.example.postscommentsretrofit.Comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postscommentsretrofit.Posts.PostsAdapter
import com.example.postscommentsretrofit.Posts.PostsInterface
import com.example.postscommentsretrofit.Posts.PostsItem
import com.example.postscommentsretrofit.R
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsActivity : AppCompatActivity() {

    lateinit var commentadpter: CommentAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        comments_recycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        comments_recycler.layoutManager = linearLayoutManager

        getCommentsData()
    }
    private fun getCommentsData() {

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()
        .create(CommentInterface::class.java)

    val retrofitData = retrofitBuilder.getData()

    retrofitData.enqueue(object : Callback<List<CommentsItem>?> {
        override fun onResponse(
            call: Call<List<CommentsItem>?>,
            response: Response<List<CommentsItem>?>
        ) {
            val resposeBody = response.body()!!
            commentadpter= CommentAdapter(baseContext,resposeBody)
            commentadpter.notifyDataSetChanged()
            comments_recycler.adapter=commentadpter


        }

        override fun onFailure(call: Call<List<CommentsItem>?>, t: Throwable) {

            Toast.makeText(this@CommentsActivity, "Fail", Toast.LENGTH_LONG).show()

        }
    })

}
}