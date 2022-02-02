package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Intent_Two : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        // Intent_Two엑티비티를 호출한 Activity의 intent이다
        val intent = intent
        val data: String? = intent.extras?.getString("extra-data")

        if (data != null) {
            Log.d("dataa", data)
        }

        (findViewById<TextView>(R.id.finish)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent()
                intent.putExtra("result", "success")
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        imageView.setImageURI(uri)


    }


}