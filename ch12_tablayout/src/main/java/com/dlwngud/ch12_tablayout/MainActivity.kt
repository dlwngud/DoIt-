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

        val tabLayout = binding.tabs
        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text = "Tab1"
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.text = "Tab2"
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.text = "Tab3"
        tabLayout.addTab(tab3)
    }
}