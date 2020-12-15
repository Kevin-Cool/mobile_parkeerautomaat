package com.example.parkeerautomatenv4.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parkeerautomatenv4.data.local.dao.GeometryDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatfieldsDao
import com.example.parkeerautomatenv4.data.local.entity.GeometryEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import com.example.parkeerautomatenv4.domain.Parkeerautomaatfields

@Database(entities = [ParkeerautomaatEntity::class, ParkeerautomaatfieldsEntity::class, GeometryEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun parkeerautomaatDao():ParkeerautomaatDao
    abstract fun parkeerautomaatfieldsDao():ParkeerautomaatfieldsDao
    abstract fun geometry():GeometryDao

    companion object{
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase  =
                instance ?: synchronized(this){ instance ?: buildDatabase(context).also { instance = it}}

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext,AppDatabase::class.java,"parkeerautomaatDB")
                        .fallbackToDestructiveMigration()
                        .build()

    }

}