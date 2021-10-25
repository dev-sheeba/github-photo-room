package com.hfad.photoroom

import android.app.Application
import com.hfad.photoroom.database.DefaultRepository
import com.hfad.photoroom.database.PhotoRoomDatabase
import com.hfad.photoroom.database.PhotoRoomDatabaseDao

class PhotoRoomApplication: Application() {
    private val database by lazy { PhotoRoomDatabase.getInstance(this)}
    val repository by lazy { DefaultRepository(database.photoRoomDatabaseDao()) }
}