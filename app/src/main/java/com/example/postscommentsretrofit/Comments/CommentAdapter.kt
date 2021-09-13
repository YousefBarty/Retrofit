package com.example.postscommentsretrofit.Comments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.postscommentsretrofit.R

class CommentAdapter(val context: Context, val commentsList: List<CommentsItem>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val commentId: TextView
        val postId: TextView
        val commentNameId: TextView
        val emailId: TextView
        val commentBody: TextView

        init {
            commentId = itemView.findViewById(R.id.commentId)
            postId = itemView.findViewById(R.id.commentpostId)
            commentNameId = itemView.findViewById(R.id.commentnameId)
            emailId = itemView.findViewById(R.id.emailID)
            commentBody = itemView.findViewById(R.id.bodyId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {

    val itemview=LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false)
        return CommentViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        holder.commentBody.text=commentsList[position].body
        holder.emailId.text=commentsList[position].email
        holder.commentNameId.text=commentsList[position].name
        holder.postId.text=commentsList[position].postId.toString()
        holder.commentId.text=commentsList[position].id.toString()
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }


}