package com.project.satyam.preganancytester

import android.app.Application
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.project.satyam.preganancytester.worker.ReminderWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class App() :Application(), Configuration.Provider {

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    override fun onCreate() {
        super.onCreate()
        scheduleVitalsReminder()
    }
// checking one time notification for testing
//    private fun scheduleVitalsReminder() {
//        val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
//            .setInitialDelay(5, TimeUnit.SECONDS) // or 0 for instant
//            .build()
//
//        WorkManager.getInstance(applicationContext).enqueueUniqueWork(
//            "VitalsReminderWork",
//            ExistingWorkPolicy.REPLACE,
//            workRequest
//        )
//    }
    private fun scheduleVitalsReminder() {
        val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS)
            .setInitialDelay(5, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "VitalsReminderWork",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}