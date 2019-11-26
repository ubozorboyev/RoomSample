package com.example.roomsample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsample.R
import com.example.roomsample.model.UserData

class UserAdapter :RecyclerView.Adapter<UserAdapter.ViewHolder>(){
var data= emptyList<UserData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)!!
      return ViewHolder(view)
    }

    override fun getItemCount(): Int=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textName.text=data[position].name
        holder.textUsername.text=data[position].username
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textName=view.findViewById<TextView>(R.id.name)
        val textUsername=view.findViewById<TextView>(R.id.username)
    }

    fun setList(data:List<UserData>){
        this.data=data
        notifyDataSetChanged()
    }

}