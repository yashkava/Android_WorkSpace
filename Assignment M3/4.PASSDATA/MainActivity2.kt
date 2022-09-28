package com.example.passdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.passdata.databinding.ActivityMain2Binding


    class MainActivity2 : AppCompatActivity() {

        lateinit var binding: ActivityMain2Binding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMain2Binding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            var i = intent
            var names = i.getStringExtra("names")

            Toast.makeText(this, names, Toast.LENGTH_LONG).show()

            binding.name.setText("Welcome " + names)
        }
    }
