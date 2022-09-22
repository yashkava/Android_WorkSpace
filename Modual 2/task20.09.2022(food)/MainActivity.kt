package com.example.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.food.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add(Model(R.drawable.pizza,"Pizza","249/-","5/4","FOOD ADDA"))
        list.add(Model(R.drawable.burger,"Burger","145/-","5/3.5","BURGER KING"))
        list.add(Model(R.drawable.sandwich,"Sandwich","190/-","5/4","RAJ MANDIR"))
        list.add(Model(R.drawable.gb,"Garlic Bread","140/-","5/4","UPTOWN"))
        list.add(Model(R.drawable.dosa,"Dosa","210/-","5/4.5","DOSA HUB"))
        list.add(Model(R.drawable.ff,"French Fries","99/-","5/4.5","MR.FOOD"))
        list.add(Model(R.drawable.nachos,"Crunchy Nachos","120/-","5/3","SIZE ZERO"))
        list.add(Model(R.drawable.gathiya,"Gathiya","50/-","5/5","JOKAR"))
        list.add(Model(R.drawable.shake,"Kitkat Shake","199/-","5/5","SANTUSHTI"))
        list.add(Model(R.drawable.brownie,"Brownie With Ice Cream","285/-","5/5","IMPERIAL PALACE"))





        var adapter =MyAdapter(this,list)
        binding.list.adapter=adapter
    }
}