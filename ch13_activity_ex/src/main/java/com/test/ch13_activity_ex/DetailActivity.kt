package com.test.ch13_activity_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.ch13_activity_ex.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 엑스트라 데이터 가져오기
        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getIntExtra("data2", 0)

        binding.tv1.text = data1
        binding.tv2.text = data2.toString()
    }
}