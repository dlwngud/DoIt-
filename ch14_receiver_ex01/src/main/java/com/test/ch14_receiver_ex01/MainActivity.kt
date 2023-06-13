package com.test.ch14_receiver_ex01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.ch14_receiver_ex01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리시버 객체 생성
        val receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {

            }
        }

        // registerReceiver() : 매니페스트에 <receiver>로 등록하지 않아도 시스템에서 리시버를 인지
        val filter = IntentFilter("ACTION_RECEIVER")
        registerReceiver(receiver, filter)

        // registerReceiver()를 사용하고 필요없으면 해제해 줘야한다.
        unregisterReceiver(receiver)

        val intent = Intent(this, MyReceiver::class.java)
        sendBroadcast(intent)
    }
}