package com.hfad.photoroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.hfad.photoroom.database.PhotoRoomDatabase
import com.hfad.photoroom.database.PhotoRoomDatabaseDao
import com.hfad.photoroom.database.PhotoRoomRepository

class PhotoRoomViewModel(
    val photoRoomRepository: PhotoRoomRepository,
) : ViewModel(){

}