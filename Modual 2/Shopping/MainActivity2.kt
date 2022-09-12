package com.example.shopping

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    lateinit var image1:ImageView
    lateinit var image2:ImageView
    lateinit var image3:ImageView
    lateinit var image4:ImageView
    lateinit var text1:TextView
    lateinit var text2:TextView
    lateinit var text3:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        image1=findViewById(R.id.img1)
        image2 = this.findViewById(R.id.img2)
        text1 = findViewById(R.id.tx1)
        image3 = findViewById(R.id.img3)
        image4 = findViewById(R.id.img4)
        text2 =findViewById(R.id.tx2)
        text3 =findViewById(R.id.tx3)

        image1.setOnClickListener()
        {
            var url="7435874674"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+url))
            startActivity(i)

        }


        image2.setOnClickListener()
        {
            var url = "https://thehouseofrare.com/products/trum-mens-logo-t-shirt-green?"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }


        text1.setOnClickListener()
        {
            Toast.makeText(applicationContext, "PRICE=999/-ONLY", Toast.LENGTH_LONG).show()
        }

        image3.setOnClickListener()
        {
            var url = "https://www.flipkart.com/tommy-hilfiger-embroidered-men-round-neck-black-t-shirt"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }


        text2.setOnClickListener()
        {
            Toast.makeText(applicationContext, "PRICE=1999/-ONLY", Toast.LENGTH_LONG).show()
        }

        image4.setOnClickListener()
        {
            var url = "https://world.benetton.com/white-t-shirt-in-organic-cotton-with-multicolored-logo-white-3I1XU100A_907.html"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }


        text3.setOnClickListener()
        {
            Toast.makeText(applicationContext, "PRICE=1999/-ONLY", Toast.LENGTH_LONG).show()
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




