package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var fiveCentImage: ImageView
    private lateinit var tenCentImage: ImageView
    private lateinit var twentyFiveCentImage: ImageView
    private lateinit var dollarImage: ImageView
    private lateinit var cashTextView: TextView
    private var money = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addEventListener()
    }

    private fun bind() {
        fiveCentImage = findViewById(R.id.image_five_cent)
        tenCentImage = findViewById(R.id.image_ten_cent)
        twentyFiveCentImage = findViewById(R.id.image_tf_cent)
        dollarImage = findViewById(R.id.image_dollar)
        cashTextView = findViewById(R.id.text_money_count)
    }
     private fun addEventListener() {
         fiveCentImage.setOnClickListener(){
             money += 0.05
             money = String.format("%.2f",money).toDouble()
             cashTextView.text = "$${money}"
         }
         tenCentImage.setOnClickListener(){
             money += 0.10
             money = String.format("%.2f",money).toDouble()
             cashTextView.text = "$${money}"
         }
         twentyFiveCentImage.setOnClickListener(){
             money +=0.25
             money = String.format("%.2f",money).toDouble()
             cashTextView.text = "$${money}"
         }
         dollarImage.setOnClickListener(){
             money += 1.00
             money = String.format("%.2f",money).toDouble()
             cashTextView.text = "$${money}"

         }
    }


}