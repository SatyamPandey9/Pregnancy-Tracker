package com.project.satyam.preganancytester.localDB

import androidx.room.*
import com.project.satyam.preganancytester.model.VitalsData
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVitals(vitalsData: VitalsData)

    @Query("SELECT * FROM VitalsData ORDER BY id DESC")
    fun getAllVitals(): Flow<List<VitalsData>>
}
