package com.example.mycolors

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycolors.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRed.setOnClickListener {
            binding.rlBg.setBackgroundResource(R.color.red)
        }
        binding.btnGreen.setOnClickListener {
            binding.rlBg.setBackgroundResource(R.color.green)
        }

        binding.btnBlue.setOnClickListener {
            binding.rlBg.setBackgroundResource(R.color.blue)
        }
        binding.btnWhite.setOnClickListener {
            binding.rlBg.setBackgroundResource(R.color.white)
        }
        binding.btnBlack.setOnClickListener {
            binding.rlBg.setBackgroundResource(R.color.black)
        }

    }
}