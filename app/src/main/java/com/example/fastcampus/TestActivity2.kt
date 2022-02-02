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

        val address = findViewById<EditText>(R.id.address)
        val webview = findViewById<WebView>(R.id.webview)
        webview.settings.javaScriptEnabled = true

        try {
            webview.loadUrl(intent.data!!.toString())
        } catch (exception: Exception) {

        }


        webview.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                Log.d("testt", "abc")
                return if (url.startsWith("file")) {
                    val intent = Intent(this@TestActivity2, TestActivity2::class.java)
                    intent.putExtra("word", Uri.parse(url).lastPathSegment)
                    startActivity(intent)
                    true
                } else false
            }
        })



        (findViewById<TextView>(R.id.open)).setOnClickListener {
            val address = address.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"))
            startActivity(intent)
        }

        address.doAfterTextChanged { }
        address.doBeforeTextChanged { text, start, count, after -> }
        address.doOnTextChanged { text, start, before, count -> }

        address.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "abc") {
                    Log.d("testt", "text is abc")
                }
                Log.d("testt", "afterTextChanged : " + s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("testt", "beforeTextChanged : " + s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("testt", "onTextChanged : " + s)
            }
        })

    }
}
