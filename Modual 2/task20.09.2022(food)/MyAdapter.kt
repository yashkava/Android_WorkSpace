package com.example.food

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context: Context, var list: MutableList<Model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return p0
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var layout =LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,p2,false)

        var image:ImageView=view.findViewById(R.id.img)
        var name:TextView=view.findViewById(R.id.name)
        var pr:TextView=view.findViewById(R.id.price)
        var rat:TextView=view.findViewById(R.id.rating)
        var rest:TextView=view.findViewById(R.id.res)


        name.setText(list.get(p0).name)
        pr.setText(list.get(p0).price)
        rat.setText(list.get(p0).rating)
        rest.setText(list.get(p0).res)
        image.setImageResource(list.get(p0).image)



        return view
    }


}