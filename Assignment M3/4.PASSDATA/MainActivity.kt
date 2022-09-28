package com.example.passdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.passdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var name = binding.name.text


            var i = Intent(this,MainActivity2::class.java)
            i.putExtra("names", name)
            startActivity(i)
        }

    }
}