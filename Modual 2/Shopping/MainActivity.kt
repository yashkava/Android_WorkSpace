package com.example.shopping



import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    lateinit var text1:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1=findViewById(R.id.txt1)

        text1.setOnClickListener {
            var i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }





    }

    override fun onBackPressed() {
        var i = Intent(this,LoginFormActivity::class.java)
        startActivity(i)

        finish()
    }


}