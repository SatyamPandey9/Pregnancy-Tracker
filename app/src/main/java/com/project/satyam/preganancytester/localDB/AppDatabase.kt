package com.project.satyam.preganancytester.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.satyam.preganancytester.model.VitalsData

@Database(entities = [VitalsData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao
}