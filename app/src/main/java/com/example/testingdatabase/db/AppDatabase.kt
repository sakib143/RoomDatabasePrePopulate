package com.example.testingdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testingdatabase.db.dao.CitiesDao
import com.example.testingdatabase.db.table.City
import com.example.testingdatabase.db.table.DataConverters
import com.example.testingdatabase.db.table.NamazList


@Database(entities = [City::class,NamazList::class], version = 1, exportSchema = false)
@TypeConverters(DataConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao(): CitiesDao


    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context,AppDatabase::class.java,"namaz.db")
                .createFromAsset("databases/namaz.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}