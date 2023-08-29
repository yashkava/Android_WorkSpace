package com.example.firebasecrud

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val usersList: ArrayList<User>,
                  private val onDeleteListener: MainActivity,
                  private val onUpdateListener:MainActivity): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    private var usersArrayList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,parent,false)

        return MyViewHolder(itemView)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = usersList[position].firstName  +  usersList[position].lastName
        holder.phone.text = usersList[position].mobile
        holder.email.text = usersList[position].email
        holder.btnDel.setOnClickListener {
            onDeleteListener.onDelete(usersList[position])
        }
        holder.btnEdit.setOnClickListener {
            onUpdateListener.onUpdate(usersList[position])
        }
    }
    override fun getItemCount(): Int {
            return usersList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.tvName)
        val phone : TextView = itemView.findViewById(R.id.tvPhone)
        val email : TextView = itemView.findViewById(R.id.tvEmail)
        val btnDel : ImageButton = itemView.findViewById(R.id.btnDel)
        val btnEdit : ImageButton = itemView.findViewById(R.id.btnEdit)

    }

    interface OnDeleteListener {

        fun onDelete(user: User)

    }
    interface OnUpdateListener {

        fun onUpdate(user: User)

    }



}

