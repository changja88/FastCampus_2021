package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)


        (findViewById<TextView>(R.id.one)).setOnClickListener {
            startActivity(Intent(this@ActivityTwo, ActivityOne::class.java))
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            startActivity(Intent(this@ActivityTwo, ActivityTwo::class.java))
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@ActivityTwo, ActivityThree::class.java))
        }
    }
}