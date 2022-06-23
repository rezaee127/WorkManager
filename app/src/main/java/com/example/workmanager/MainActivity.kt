package com.example.workmanager

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.work.*
import java.util.concurrent.TimeUnit

const val CHANNEL_ID="10"

//https://developer.android.com/training/notify-user/build-notification

//https://developer.android.com/topic/libraries/architecture/workmanager/basics
//https://developer.android.com/codelabs/android-workmanager#0
//خیلی خوبه //  https://flexiple.com/android/android-workmanager-tutorial-getting-started
//https://medium.com/androiddevelopers/workmanager-periodicity-ff35185ff006


class MainActivity : AppCompatActivity() {
    @SuppressLint("IdleBatteryChargingConstraints")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel(this)




//یک بار نوتیفیکیشن بده
//        val NotifyWorkRequest: WorkRequest =
//            OneTimeWorkRequestBuilder<NotifyWorker>()
//                .build()
//
//        WorkManager
//            .getInstance(this)
//            .enqueue(NotifyWorkRequest)





//هر 15 دقیقه نوتیفیکیشن بده . حداقلش 15 دقیقه هست
        val myUploadWork = PeriodicWorkRequestBuilder<NotifyWorker>(
            15, TimeUnit.MINUTES, // repeatInterval (the period cycle)
            15, TimeUnit.MINUTES) // flexInterval
            .build()

        WorkManager
            .getInstance(this)
            .enqueue(myUploadWork)








//حالت سوم در زمان خاص نوتیفیکیشن بده. مثل زمان کمبود باتری
//
//    val constraints2 = Constraints.Builder()
//        .setRequiresBatteryNotLow(true)
//        .setRequiredNetworkType(NetworkType.CONNECTED)
//        .setRequiresCharging(true)
//        .setRequiresStorageNotLow(true)
//        .setRequiresDeviceIdle(true)
//        .build()
//
//    val oneTimeWorkRequest = OneTimeWorkRequestBuilder<NotifyWorker>()
//        .setConstraints(constraints2)
//        .build()
//
//    WorkManager
//    .getInstance(this)
//    .enqueue(oneTimeWorkRequest)

    }

}