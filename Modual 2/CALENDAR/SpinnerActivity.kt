package com.example.calanderview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.calanderview.databinding.ActivityHomeBinding
import com.example.calanderview.databinding.ActivitySpinnerBinding
import java.util.*


class SpinnerActivity : AppCompatActivity() {
    lateinit var txt:TextView
    lateinit var btn:Button
    lateinit var date:DatePicker
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
    txt=findViewById(R.id.txt)
    btn=findViewById(R.id.btn)
    date=findViewById(R.id.date_Picker)

        btn.setOnClickListener {
            txt.text =
                "Selected Date: " + date.dayOfMonth + "/" + (date.month + 1) + "/" + date.year
        }
    }
}