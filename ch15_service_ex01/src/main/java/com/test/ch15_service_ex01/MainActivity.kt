package com.test.ch15_service_ex01

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // startService() 함수로 실행
        // 서비스 실행
        // val intent = Intent(this, MyService::class.java)
        // startService(intent)

        // 암시적 인텐트로 실행
        //val intent = Intent("ACTION_OUTER_SERVICE")
        //intent.setPackage("com.test.test_outter")
        // startService(intent)

        // 서비스 종료
        //stopService(intent)

        // bindService() 함수로 실행
        val connection: ServiceConnection = object: ServiceConnection{
            // bindService() 함수로 서비스를 구동할 때 자동으로 호출
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                TODO("Not yet implemented")
            }

            // unbindService() 함수로 서비스를 종료할 때 자동으로 호출
            override fun onServiceDisconnected(name: ComponentName?) {
                TODO("Not yet implemented")
            }
        }

        val intent = Intent(this, MyService::class.java)
        // 인텐트 객체, ServiceConnection을 구현한 객체, Int 타입의 flags
        bindService(intent,connection, Context.BIND_AUTO_CREATE)

        // 서비스 종료
        unbindService(connection)
    }
}