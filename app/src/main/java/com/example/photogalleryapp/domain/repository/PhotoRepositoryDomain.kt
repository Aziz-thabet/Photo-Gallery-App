package com.example.photogalleryapp.domain.repository


import com.example.photogalleryapp.domain.models.PhotoModel
interface PhotoRepositoryDomain {
    suspend fun getPhotos(forceRefresh: Boolean): List<PhotoModel>

    suspend fun savePhoto(photo: PhotoModel)
}