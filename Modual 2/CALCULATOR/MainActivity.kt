package com.example.mycal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var ans: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        ans = findViewById(R.id.ans)

        findViewById<Button>(R.id.add).setOnClickListener(this)
        findViewById<Button>(R.id.sub).setOnClickListener(this)
        findViewById<Button>(R.id.mul).setOnClickListener(this)
        findViewById<Button>(R.id.div).setOnClickListener(this)
        findViewById<Button>(R.id.per).setOnClickListener(this)
        findViewById<Button>(R.id.res).setOnClickListener(this)
    }
    private fun inputIsNotEmpty(): Boolean {
        var b = true
        if (num1.text.toString().trim().isEmpty()) {
            num1.error = "Required"
            num1.requestFocus()
            b = false
        }
        if (num2.text.toString().trim().isEmpty()) {
            num2.error = "Required"
            num2.requestFocus()
            b = false
        }
        return b
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        if (inputIsNotEmpty())

            when (v?.id) {
                R.id.add -> {
                    ans.text =
                        (num1.text.toString().toBigDecimal() + num2.text.toString()
                            .toBigDecimal()).toString() }
                R.id.sub -> {
                    ans.text =
                        (num1.text.toString().toBigDecimal() - num2.text.toString()
                            .toBigDecimal()).toString() }
                R.id.mul -> {
                    ans.text =
                        (num1.text.toString().toBigDecimal() * num2.text.toString()
                            .toBigDecimal()).toString() }
                R.id.div -> {
                    ans.text =
                        (num1.text.toString().toBigDecimal() / num2.text.toString()
                            .toBigDecimal()).toString() }
                R.id.per -> {
                    if (num1.text.toString() < num2.text.toString()) {
                        Toast.makeText(applicationContext,
                        "PLEASE ENTER SMALLER NUMER IN FIRST VALUE",
                        Toast.LENGTH_SHORT).show()
                } else {
                    ans.text =
                        ((num1.text.toString().toBigDecimal() / num2.text.toString()
                            .toBigDecimal()) * 100.toString().toBigDecimal()).toString() }

                }

                    R.id.res -> {
                    num1.text.clear()
                    num2.text.clear()

                }
            }
    }
}




