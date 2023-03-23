package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
//Variables UI
    private lateinit var nWeightEditText: EditText
    private lateinit var nHeightEditText: EditText

    private lateinit var nSendButton: Button
    private lateinit var nDisplayTextView: TextView
    private lateinit var imb: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        nDisplayTextView.text  = ""
        nSendButton.setOnClickListener{

            val weight = nWeightEditText.text.toString()

            val height = nHeightEditText.text.toString()

            val result = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

            if(result < 18.5){
                val response="underweight"
            }
            if(result > 18.5 && result < 24.99){
            val response="Healthy"
        }
            if(result > 25 &&  result < 29.00){
            val response="Overweight"
        }
            if(result > 30){
                val imb="underweight"
            }

            val response =""
            nDisplayTextView.text = getString(R.string.greeting_text,result, response)



        }
    }



    private fun bind(){

        nSendButton = findViewById(R.id.action_send)
        nWeightEditText = findViewById(R.id.weight_edit_text)
        nDisplayTextView = findViewById(R.id.display_greeting)
        nHeightEditText = findViewById(R.id.height_edit_text)
    }
}