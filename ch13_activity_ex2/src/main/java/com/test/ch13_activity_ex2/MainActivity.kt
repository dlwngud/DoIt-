package com.test.ch13_activity_ex2

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.ch13_activity_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            count++
            binding.textView.text = count.toString()
        }

        // 세로모드에서 가로모드로 전환할 때 데이터 유지
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count",0)
            binding.textView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // 번들에 데이터 저장
        outState.putInt("count", count)
    }
}