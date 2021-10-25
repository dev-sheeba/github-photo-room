package com.hfad.photoroom.database

class DefaultRepository(private val dao: PhotoRoomDatabaseDao) : PhotoRoomRepository {
    override suspend fun upsert(photo: Photo) = dao.upsert(photo)

    override fun getPhoto(key: Long): Photo? = dao.getPhoto(key)

    override suspend fun deletePhoto(photoId: Long) = dao.deletePhoto(photoId)

    override suspend fun deleteAll() = dao.deleteAll()
}