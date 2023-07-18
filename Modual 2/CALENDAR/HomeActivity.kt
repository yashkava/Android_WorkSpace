package com.example.calanderview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calanderview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.img1.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i) }


        binding.link1.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i) }


        binding.img2.setOnClickListener {
            var i = Intent(this, SpinnerActivity::class.java)
            startActivity(i) }


        binding.link2.setOnClickListener {
            var i = Intent(this, SpinnerActivity::class.java)
            startActivity(i) }


        }
    }
