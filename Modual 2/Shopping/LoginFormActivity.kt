package com.example.shopping

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFormActivity : AppCompatActivity()
{
    lateinit var btn1: Button
    lateinit var edt1: EditText
    lateinit var edt2: EditText


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        btn1=findViewById(R.id.btn1)
        edt1=findViewById(R.id.et1)
        edt2=findViewById(R.id.et2)


        btn1.setOnClickListener()
        {

            var n = edt1.text.toString()
            var p = edt2.text.toString()

            if (n.length == 0 && p.length == 0) {
                edt1.setError("Please Enter Mobile Number")
                edt2.setError("Please Enter Password")
            } else if (n.length == 0) {
                edt1.setError("Please Enter Mobile Number")
            } else if (p.length == 0) {
                edt2.setError("Please Enter Password")
            } else {
                if (n.equals("7435874674") && p.equals("1708")) {
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_LONG).show()
                    var i = Intent(this, MainActivity2::class.java)
                    startActivity(i)
                } else {
                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG).show()

                }


            }

        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }


}