package com.d3if4065.luassegitiga.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Segi3Entity::class], version = 1, exportSchema = false)

abstract class segi3DB : RoomDatabase() {
    abstract val dao: segi3Dao

    companion object {
        @Volatile
        private var INSTANCE: segi3DB? = null
        fun getInstance(context: Context): segi3DB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        segi3DB::class.java,
                        "bmi.db"
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