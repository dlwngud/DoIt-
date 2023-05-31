package com.dlwngud.ch12_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dlwngud.ch12_tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}