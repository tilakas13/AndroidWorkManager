package com.tilak.apps.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import androidx.work.impl.constraints.trackers.NetworkStateTracker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        val workRequest = OneTimeWorkRequestBuilder<NetworkStateWorker>()
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)



        val periodicRequest =  PeriodicWorkRequestBuilder<PeriodicWorker>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()


        WorkManager.getInstance(applicationContext).enqueue(periodicRequest)
    }
}