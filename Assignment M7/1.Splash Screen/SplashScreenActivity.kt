package com.example.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class SplashScreenActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        class SplashScreenActivity : AppCompatActivity()
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(Runnable {

            var i =Intent(this,MainActivity::class.java)
            startActivity(i)


        },3000)

    }

}