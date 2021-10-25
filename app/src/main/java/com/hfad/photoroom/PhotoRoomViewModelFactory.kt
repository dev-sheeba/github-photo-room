package com.hfad.photoroom

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.photoroom.database.PhotoRoomDatabaseDao
import com.hfad.photoroom.database.PhotoRoomRepository
import java.lang.IllegalArgumentException

class PhotoRoomViewModelFactory(private val photoRoomRepository: PhotoRoomRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotoRoomViewModel(photoRoomRepository) as T
    }
}