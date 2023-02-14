package com.example.m4q3

import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m4q3.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var answer:Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var firstNumberValue = Integer.parseInt(binding.edt1.getText().toString())
            var secondNumberValue = Integer.parseInt(binding.edt2.getText().toString())
            var operatorButtonId = binding.operators.getCheckedRadioButtonId()


            if(operatorButtonId == binding.add.getId())
            {
                answer = firstNumberValue + secondNumberValue
            }
            else if(operatorButtonId == binding.sub.getId())
            {
                answer = firstNumberValue - secondNumberValue
            }
            else if(operatorButtonId == binding.mul.getId())
            {
                answer = firstNumberValue * secondNumberValue
            }
            else if(operatorButtonId == binding.div.getId())
            {
                answer = firstNumberValue / secondNumberValue
            }
            binding.result.setText(answer.toString())
        }

    }
}