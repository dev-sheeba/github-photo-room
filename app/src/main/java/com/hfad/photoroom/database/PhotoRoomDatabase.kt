package com.hfad.photoroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class PhotoRoomDatabase: RoomDatabase() {

    abstract fun photoRoomDatabaseDao(): PhotoRoomDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE:PhotoRoomDatabase? = null
        fun getInstance(context: Context): PhotoRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhotoRoomDatabase::class.java,
                        "photo_room_database"
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