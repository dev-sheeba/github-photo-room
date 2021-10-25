package com.hfad.photoroom.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhotoRoomDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(photo: Photo)

    @Query("SELECT * from photo_room_table WHERE photoId = :photoId")
    fun getPhoto(photoId: Long): Photo?

    @Query("DELETE FROM photo_room_table WHERE photoId = :photoId")
    suspend fun deletePhoto(photoId: Long)

    @Query("DELETE FROM photo_room_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM photo_room_table ORDER BY photoId DESC")
    fun getAllPhotos(): LiveData<List<Photo>>

}