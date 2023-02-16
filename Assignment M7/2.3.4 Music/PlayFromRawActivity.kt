package com.example.module7

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PlayFromRawActivity : AppCompatActivity()
{
    lateinit var mediaPlayer: MediaPlayer
    lateinit var startbutton:Button
    lateinit var stopbutton:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_from_raw)
        mediaPlayer=MediaPlayer.create(this,R.raw.miley_cyrus_flowers)
        startbutton=findViewById(R.id.start_button_id)
        stopbutton=findViewById(R.id.stop_button_id)

        startbutton.setOnClickListener {
            mediaPlayer.start()
        }
        stopbutton.setOnClickListener {
            mediaPlayer.stop()
        }
    }
}