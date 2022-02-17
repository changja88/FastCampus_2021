package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)


        var carList = mutableListOf<Car>()
        for (i in 0..30) {
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.container)
        val inflater = LayoutInflater.from(this@AddViewActivity)
        carList.forEach {
            val carItemView = inflater.inflate(R.layout.car_item, null)
            val carImage = carItemView.findViewById<ImageView>(R.id.carImage)
            val nthCar = carItemView.findViewById<TextView>(R.id.nthCar)
            val nthEnigne = carItemView.findViewById<TextView>(R.id.nthEngine)

            carImage.setImageDrawable(resources.getDrawable(R.drawable.blue_background, this.theme))
            nthCar.text = it.nthCar
            nthEnigne.text = it.nthEngine

            container.addView(carItemView)
        }
    }
}


class Car(val nthCar: String, val nthEngine: String)