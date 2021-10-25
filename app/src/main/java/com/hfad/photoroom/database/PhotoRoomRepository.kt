package com.hfad.photoroom.database

interface PhotoRoomRepository {

    suspend fun upsert(photo: Photo)

    fun getPhoto(photoId: Long): Photo?

    suspend fun deletePhoto(photoId: Long)

    suspend fun deleteAll()

}