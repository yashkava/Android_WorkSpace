package com.example.shopping

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AlertDialog.*
import android.widget.Button

class MainActivity3 : AppCompatActivity()


{
    lateinit var bt1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        bt1 = findViewById(R.id.btn1)

        bt1.setOnClickListener {

            finishAffinity()

        }
    }
        override fun onBackPressed() {

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Are you sure you want to exit?")
            alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                finishAffinity()

            })
            alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()
            })
            alert.show()

        }
}