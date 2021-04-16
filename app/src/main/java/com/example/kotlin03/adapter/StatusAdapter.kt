package com.example.kotlin03.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin03.R
import com.example.kotlin03.model.Status

class StatusAdapter(private val click: ClickListener) : RecyclerView.Adapter<StatusAdapter.ViewHolder>() {
    private var listStatus: ArrayList<Status> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var senderName: TextView = itemView.findViewById(R.id.tv_sender_name)
        var status: TextView = itemView.findViewById(R.id.tv_status)
        var amount: TextView = itemView.findViewById(R.id.tv_amount)
        var dotted : ImageView = itemView.findViewById(R.id.dotted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_status, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listStatus.size > 3) {
            3
        } else {
            return listStatus.size
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StatusAdapter.ViewHolder, position: Int) {
        val status: Status = listStatus[position]
        holder.amount.text = status.amount.toString() + "€"
        if(status.amount > 0){
            holder.amount.setTextColor(Color.parseColor("#00c55b"))
        }
        holder.senderName.text = status.name
        holder.status.text = status.status
        if (position == 0){
            holder.dotted.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            click.onClickListener()
        }
    }

    fun setData(data : ArrayList<Status>){
        listStatus = data
        notifyDataSetChanged()
    }
    interface ClickListener {
        fun onClickListener()
    }
}
