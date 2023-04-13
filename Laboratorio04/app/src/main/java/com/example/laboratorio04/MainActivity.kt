package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var phoneNumberEditText: TextInputEditText
    private lateinit var actionNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

     private fun bind() {
        nameEditText = findViewById(R.id.name_value)
        emailEditText = findViewById(R.id.email_value)
        phoneNumberEditText = findViewById(R.id.phone_value)
         actionNext = findViewById(R.id.action_next)
    }

     private fun addListeners() {
        actionNext.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name",nameEditText.text.toString())
            intent.putExtra("email",emailEditText.text.toString())
            intent.putExtra("phone",phoneNumberEditText.text.toString())
            startActivity(intent)
        }
    }
}