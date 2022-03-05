package com.example.fastcampus

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)



        findViewById<TextView>(R.id.askPermission).setOnClickListener {
            val cameraPermission = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                // 권한이 있는 경우
                Log.d("testt", "카메라 권한 있음")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000){
            // 우리가 보낸 권한 요청이 맞다면
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d("testt", "승낙")
            }else {
                Log.d("testt", "거부")
            }
        }
    }
}