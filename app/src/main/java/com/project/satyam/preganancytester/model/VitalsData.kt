package com.project.satyam.preganancytester.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VitalsData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val heartRate: Int,
    val weight: Int,
    val bloodPressure: String, // e.g. "120/80 mmHg"
    val kicks: Int,
    val timestamp: String
)