package com.example.fireimage

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter(private val itmlst : ArrayList<itemDs>):RecyclerView.Adapter<itemAdapter.itmHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class itmHolder(itmView: View,listener: onItemClickListener):RecyclerView.ViewHolder(itmView){
        val itmName:TextView=itmView.findViewById(R.id.tvName)
        val itemDs:TextView=itmView.findViewById(R.id.tvDes)
        val itemImg:ImageView=itmView.findViewById(R.id.tvImage)
        init {

            itmView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itmHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
    return itmHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: itmHolder, position: Int) {
        val currentItem = itmlst[position]
        holder.itmName.text =currentItem.itemName.toString()
        holder.itemDs.text =currentItem.itemDes.toString()
        val bytes = android.util.Base64.decode(currentItem.itemImg,android.util.Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        holder.itemImg.setImageBitmap(bitmap)

    }

    override fun getItemCount(): Int {
    return itmlst.size

    }
}