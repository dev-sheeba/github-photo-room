package com.hfad.photoroom.database

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_room_table")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    var photoId: Long,
    @ColumnInfo(name = "photo_image")
    var photoImage: Uri
)