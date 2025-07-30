package com.project.satyam.preganancytester.di

import android.content.Context
import androidx.room.Room
import com.project.satyam.preganancytester.localDB.AppDatabase
import com.project.satyam.preganancytester.localDB.VitalsDao
import com.project.satyam.preganancytester.repository.VitalsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "vitals_db"
            ).fallbackToDestructiveMigration(false).build()
    }

    @Provides
    fun provideVitalsDao(db: AppDatabase): VitalsDao = db.vitalsDao()

    @Provides
    @Singleton
    fun provideRepository(dao: VitalsDao): VitalsRepository {
        return VitalsRepository(dao)
    }
}