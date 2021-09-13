package com.example.postscommentsretrofit.Posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postscommentsretrofit.R
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsActivity : AppCompatActivity() {

    lateinit var postadpter: PostsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        posts_recycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        posts_recycler.layoutManager = linearLayoutManager

        // 1_Model class (used as a JSON model)
        // 2_ interface ( define the possible HTTP operation)
        // 3_ instance which uses the interface and the builder API

        getPostsData()
    }

    private fun getPostsData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(PostsInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<PostsItem>?> {
            override fun onResponse(
                call: Call<List<PostsItem>?>,
                response: Response<List<PostsItem>?>
            ) {
                val resposeBody = response.body()!!
                postadpter= PostsAdapter(baseContext,resposeBody)
                postadpter.notifyDataSetChanged()
                posts_recycler.adapter=postadpter


            }

            override fun onFailure(call: Call<List<PostsItem>?>, t: Throwable) {

                Toast.makeText(this@PostsActivity, "Fail", Toast.LENGTH_LONG).show()

            }
        })

    }
}