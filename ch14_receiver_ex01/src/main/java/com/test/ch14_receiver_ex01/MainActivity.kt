package com.test.ch14_receiver_ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.ch14_receiver_ex01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}