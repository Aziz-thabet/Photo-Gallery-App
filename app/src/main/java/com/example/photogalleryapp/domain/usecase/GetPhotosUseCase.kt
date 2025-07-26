package com.example.photogalleryapp.domain.usecase

import com.example.photogalleryapp.domain.models.PhotoModel
import com.example.photogalleryapp.domain.repository.PhotoRepository

class GetPhotosUseCase(private val photoRepository: PhotoRepository) {

    suspend operator fun invoke(forceRefresh: Boolean): List<PhotoModel> {
        return photoRepository.getPhotos(forceRefresh)
    }
}