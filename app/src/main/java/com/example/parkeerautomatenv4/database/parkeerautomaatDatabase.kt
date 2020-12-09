package com.example.parkeerautomatenv4.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

@Database(entities = [Parkeerautomaat::class], version = 1,  exportSchema = false)
abstract class parkeerautomaatDatabase  : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: parkeerautomaatDatabase? = null
        fun getInstance(context: Context): parkeerautomaatDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {instance = Room.databaseBuilder(
                        context.applicationContext,
                        parkeerautomaatDatabase::class.java,
                        "parkeerautomaat_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}