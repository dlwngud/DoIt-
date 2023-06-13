package com.test.ch14_receiver_ex01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
                when(intent?.action){
                    Intent.ACTION_SCREEN_ON -> Log.d("kkang", "screen on")
                    Intent.ACTION_SCREEN_OFF -> Log.d("kkang", "screen off")
                }
            }
        }

        // registerReceiver() : 매니페스트에 <receiver>로 등록하지 않아도 시스템에서 리시버를 인지
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON).apply {
            addAction(Intent.ACTION_SCREEN_OFF)
        }
        registerReceiver(receiver, filter)

        // registerReceiver()를 사용하고 필요없으면 해제해 줘야한다.
        unregisterReceiver(receiver)

        // val intent = Intent(this, MyReceiver::class.java)
        // sendBroadcast(intent)

        val batteryReceiver = MyReceiver()
        val filter1 = IntentFilter(Intent.ACTION_BATTERY_LOW).apply {
            addAction(Intent.ACTION_BATTERY_OKAY)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(batteryReceiver, filter1)

        // 시스템 인텐트 없이 배터리 상태 파악하기
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = registerReceiver(null, intentFilter)

        // 인텐트의 엑스트라를 이용해 배터리 상태 파악하기
        val status = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        if(status == BatteryManager.BATTERY_STATUS_CHARGING){
            // 전원이 공급되고 있다면
            val chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            when(chargePlug){
                BatteryManager.BATTERY_PLUGGED_USB -> Log.d("kkang", "use charge")
                BatteryManager.BATTERY_PLUGGED_AC -> Log.d("kkang", "ac charge")
            }
        } else{
            // 전원이 공급되고 있지 않다면
            Log.d("kkang", "not charge")
        }

        // 배터리 충전량을 퍼센트로 출력
        val level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level / scale.toDouble() * 100
        Log.d("kkang","batteryPct : $batteryPct")
    }
}