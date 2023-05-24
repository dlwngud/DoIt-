package com.dlwngud.ch11_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dlwngud.ch11_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}