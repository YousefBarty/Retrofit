package com.example.postscommentsretrofit.Posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.postscommentsretrofit.R

class PostsAdapter(val context: Context, val postsList: List<PostsItem>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {


    inner class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        var postId:TextView
        var postTitle:TextView

        init {
            postId=itemView.findViewById(R.id.postId)
            postTitle=itemView.findViewById(R.id.posttitleId)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        var itemview=LayoutInflater.from(context).inflate(R.layout.post_item,parent,false)
        return PostViewHolder(itemview)
  }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.postId.text=postsList[position].userId.toString()
        holder.postTitle.text=postsList[position].title
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}