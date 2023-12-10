package com.example.cinema.data.DataBase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cinema.data.NetworkEntitys.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {
    abstract fun moviesDao(): MovieDAO

    companion object {

        private var INSTANCE: MoviesDB? = null
        private val LOCK = Any()
        private const val DB_NAME = "Movie.db"

        fun getInstance(application: Context): MoviesDB {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application, MoviesDB::class.java, DB_NAME
                ).build()
                INSTANCE = db
                Log.d("MoviesDB", "Creating database...${INSTANCE}")
                return db
            }
        }
    }
}