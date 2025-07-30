package com.project.satyam.preganancytester.repository

import com.project.satyam.preganancytester.localDB.VitalsDao
import com.project.satyam.preganancytester.model.VitalsData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VitalsRepository @Inject constructor(private val dao: VitalsDao) {
    fun getAllVitals(): Flow<List<VitalsData>> = dao.getAllVitals()
    suspend fun insertVitals(vitalsData: VitalsData) = dao.insertVitals(vitalsData)
}

