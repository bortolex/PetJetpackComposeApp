package com.example.petjetpackcomposeapp.ipc

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class RemoteService : Service() {

    private var messageCount = 0

    private val binder = object : IMessageService.Stub() {

        override fun processMessage(input: String): String {
            messageCount++
            val pid = android.os.Process.myPid()
            Log.d("RemoteService", "Processing in PID: $pid")

            Thread.sleep(300)

            return buildString {
                append("✅ Оброблено процесом :remote\n")
                append("PID: $pid\n")
                append("Вхід: \"$input\"\n")
                append("Результат: ${input.uppercase().reversed()}\n")
                append("Час: ${System.currentTimeMillis()}")
            }
        }

        override fun getProcessedCount(): Int = messageCount
    }

    override fun onBind(intent: Intent): IBinder = binder

    override fun onCreate() {
        super.onCreate()
        Log.d("RemoteService", "Service started in PID: ${android.os.Process.myPid()}")
    }
}
