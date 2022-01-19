package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        // 한번만 하면 되는 작업
        Log.d("LifeCycle", "onCreate")

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

        }

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }

        })


    }

    override fun onResume() {
        Log.d("LifeCycle", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LifeCycle", "onStop")
        super.onStop()
    }


    override fun onStart() {
        Log.d("LifeCycle", "onStart")
        super.onStart()
    }

    override fun onDestroy() {
        Log.d("LifeCycle", "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d("LifeCycle", "onRestart")
        super.onRestart()
    }
}




