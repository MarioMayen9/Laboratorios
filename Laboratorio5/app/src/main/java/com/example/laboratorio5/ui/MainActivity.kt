package com.example.laboratorio5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio5.R
import com.example.laboratorio5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }
}