package com.example.calanderview


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    var picker: DatePickerDialog? = null
    var edt: EditText? = null
    var btnGet: Button? = null
    var txt1: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1 = findViewById<View>(R.id.txt1) as TextView
        edt = findViewById<View>(R.id.edt1) as EditText
        edt!!.inputType = InputType.TYPE_NULL
        edt!!.setOnClickListener {
            val cldr = Calendar.getInstance()

            val day = cldr[Calendar.DAY_OF_MONTH]
            val month = cldr[Calendar.MONTH]
            val year = cldr[Calendar.YEAR]
            picker = DatePickerDialog(this,
                { view, year, monthOfYear, dayOfMonth -> edt!!.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day)
            picker!!.show()
        }
        btnGet = findViewById<View>(R.id.btn1) as Button
        btnGet!!.setOnClickListener { txt1!!.text = "Selected Date: " + edt!!.text }
    }
}