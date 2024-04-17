package edu.temple.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        runTimer(intent?.getIntExtra(timerTimeKey,10))
        return super.onStartCommand(intent, flags, startId)
    }
    fun runTimer(time : Int?){
        CoroutineScope(Job() + Dispatchers.Default).launch{
            repeat(time!!){
                Log.d("Countdown","${time-it}")
                delay(1000)
            }
            stopSelf()
        }
    }
}