package com.example.kotlin03.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin03.R
import com.example.kotlin03.model.Sender
import java.util.*

class SendAgainAdapter : RecyclerView.Adapter<SendAgainAdapter.ViewHolder>() {
    var senderList: ArrayList<Sender> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var senderName: TextView = itemView.findViewById(R.id.tv_user_name)
        var senderAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SendAgainAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_send_again, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (senderList.size > 4) {
            4
        } else {
            senderList.size
        }
    }

    override fun onBindViewHolder(holder: SendAgainAdapter.ViewHolder, position: Int) {
        val sender: Sender = senderList[position]
        holder.senderName.text = sender.name
        Glide.with(holder.itemView.context)
            .load(sender.avatar_url)
            .centerCrop()
            .into(holder.senderAvatar)
    }

    fun setData(data: ArrayList<Sender>) {
        senderList = data
        notifyDataSetChanged()
    }
}