package com.tilak.apps.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class NetworkStateWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d(TAG, "NetworkStateWorker - doWork: ")
        return Result.success()
    }
}