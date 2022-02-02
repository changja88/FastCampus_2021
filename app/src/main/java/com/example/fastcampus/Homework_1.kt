package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Homework_1 : AppCompatActivity() {

    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView

    lateinit var ca: TextView
    lateinit var plus: TextView
    lateinit var equal: TextView

    lateinit var result: TextView

    var input: String = ""
    var temp: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1)

        findViews()
        setNumberTextViewListenr()

        ca.setOnClickListener {
            input = ""
            temp = ""
            result.text = "0"
        }
        plus.setOnClickListener {
            temp = result.text.toString()
            result.text = ""
            input = ""
        }
        equal.setOnClickListener {
            val finalResult: String = (input.toInt() + temp.toInt()).toString()
            result.text = finalResult
            temp = finalResult
        }

    }

    fun setNumberTextViewListenr() {
        val numberTextViewList: List<TextView> = listOf(
            one, two, three, four, five, six, seven, eight, nine, zero
        )
        val listenr = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                input += (p0 as TextView).text
                result.text = input
            }
        }
        numberTextViewList.forEach { it.setOnClickListener(listenr) }
    }

    fun findViews() {
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        ca = findViewById(R.id.ca)
        result = findViewById(R.id.result)
    }


}