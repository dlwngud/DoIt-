package com.test.ch13_activity_ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.test.ch13_activity_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MainActivity 에서 DetailActivity 를 실행할 때
        // val intent = Intent(this, DetailActivity::class.java)
        // startActivity(intent)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {
            val resultData = it.data?.getStringExtra("result")
            binding.tv.text = resultData
        }

        binding.btn.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello")
            intent.putExtra("data2", 10)
            requestLauncher.launch(intent)
        }
    }
}