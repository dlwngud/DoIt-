package com.test.ch14_receiver_ex01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            Intent.ACTION_BATTERY_OKAY -> Log.d("kkang","ACTION_BATTERY_OKAY")
            Intent.ACTION_BATTERY_LOW -> Log.d("kkang","ACTION_BATTERY_LOW")
            Intent.ACTION_BATTERY_CHANGED -> Log.d("kkang","ACTION_BATTERY_CHANGED")
            Intent.ACTION_POWER_CONNECTED -> Log.d("kkang","ACTION_POWER_CONNECTED")
            Intent.ACTION_POWER_DISCONNECTED -> Log.d("kkang","ACTION_POWER_DISCONNECTED")
        }
    }
}