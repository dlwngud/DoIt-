package com.test.ch15_service_ex01

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}