package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        var phonebookList = mutableListOf<PhoneBook>()
        for (i in 0..40) {
            phonebookList.add(
                PhoneBook("" + i + "번째 사람", "010-000-000" + i)
            )
        }

        val container = findViewById<LinearLayoutCompat>(R.id.container)
        val inflater = LayoutInflater.from(this)
        phonebookList.forEach { phoneBook ->

            val phonebookItem = inflater.inflate(R.layout.phonebook_item, null)
            val image = phonebookItem.findViewById<ImageView>(R.id.image)
            val name = phonebookItem.findViewById<TextView>(R.id.name)
            val number = phonebookItem.findViewById<TextView>(R.id.number)

            image.setImageDrawable(resources.getDrawable(R.drawable.logo_kt, this.theme))
            name.text = phoneBook.name
            number.text = phoneBook.number

            container.addView(phonebookItem)

            phonebookItem.setOnClickListener {
                startActivity(
                    Intent(this, PhoneBookDetailActivity::class.java).apply {
                        this.putExtra("name", phoneBook.name)
                        this.putExtra("number", phoneBook.number)
                    }
                )
            }
        }


    }
}

class PhoneBook(val name: String, val number: String)