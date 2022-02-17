package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)


        val name: String = intent.extras?.getString("name") ?: ""
        val number: String = intent.extras?.getString("number") ?: ""

        findViewById<TextView>(R.id.name).text = name
        findViewById<TextView>(R.id.number).text = number

    }
}