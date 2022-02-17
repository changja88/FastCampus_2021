package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.webkit.WebViewClient
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import java.lang.Exception

//<intent-filter>
//<category android:name="android.intent.category.DEFAULT" />
//<category android:name="android.intent.category.BROWSABLE" />
//<category android:name="android.intent.category.LAUNCHER" />
//
//<action android:name="android.intent.action.MAIN" />
//<action android:name="android.intent.action.VIEW" />
//
//<data
//android:host="*"
//android:scheme="http" />
//</intent-filter>

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        val name = intent.extras?.getString("name") ?: ""
        val number = intent.extras?.getString("number") ?: ""


        findViewById<TextView>(R.id.name).text = name
        findViewById<TextView>(R.id.number).text = number

    }
}
