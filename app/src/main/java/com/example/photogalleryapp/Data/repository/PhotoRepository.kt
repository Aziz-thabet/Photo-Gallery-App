// photogalleryapp/data/repository/PhotoRepository.kt
package com.example.photogalleryapp.data.repository

import com.example.photogalleryapp.domain.models.PhotoModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log
import com.example.photogalleryapp.Data.local.PhotoDao
import com.example.photogalleryapp.Data.local.PhotoEntity
import com.example.photogalleryapp.Data.local.PhotoSrcEntity
import com.example.photogalleryapp.Data.remote.PexelsApiService
import com.example.photogalleryapp.domain.repository.PhotoRepositoryDomain
class PhotoRepository(
    private val dao: PhotoDao,
    private val pexelsApiService: PexelsApiService
) : PhotoRepositoryDomain {

    override suspend fun getPhotos(forceRefresh: Boolean): List<PhotoModel> = withContext(Dispatchers.IO) {
        var photosToReturn: List<PhotoModel> = emptyList()

        try {
            if (forceRefresh || dao.getAllPhotos().isEmpty()) {
                val response = pexelsApiService.getCuratedPhotos(page = 1, perPage = 80)
                if (response.isSuccessful) {
                    val pexelsResponse = response.body()
                    pexelsResponse?.let {
                        val newPhotoEntities = it.photos.map { remotePhoto ->
                            PhotoEntity(
                                id = remotePhoto.id,
                                url = remotePhoto.src.portrait,
                                photographer = remotePhoto.photographer,
                                src = PhotoSrcEntity(
                                    portrait = remotePhoto.src.portrait,
                                    original = remotePhoto.src.original,
                                    medium = remotePhoto.src.medium,
                                    large = remotePhoto.src.large,
                                    tiny = remotePhoto.src.tiny,
                                    landscape = remotePhoto.src.landscape
                                )
                            )
                        }
                        dao.deleteAll()
                        dao.insertPhotos(newPhotoEntities)
                        photosToReturn = newPhotoEntities.map { entity ->
                            PhotoModel(
                                id = entity.id,
                                imageUrl = entity.url,
                                photographerName = entity.photographer
                            )
                        }
                    } ?: run {
                        Log.e("PhotoRepository", "API response body is null.")
                    }
                } else {
                    Log.e("PhotoRepository", "API call failed with code: ${response.code()}, message: ${response.message()}")
                    photosToReturn = dao.getAllPhotos().map { entity ->
                        PhotoModel(
                            id = entity.id,
                            imageUrl = entity.url,
                            photographerName = entity.photographer
                        )
                    }
                }
            } else {
                photosToReturn = dao.getAllPhotos().map { entity ->
                    PhotoModel(
                        id = entity.id,
                        imageUrl = entity.url,
                        photographerName = entity.photographer
                    )
                }
            }
        } catch (e: Exception) {
            Log.e("PhotoRepository", "Error fetching photos: ${e.message}", e)
            photosToReturn = dao.getAllPhotos().map { entity ->
                PhotoModel(
                    id = entity.id,
                    imageUrl = entity.url,
                    photographerName = entity.photographer
                )
            }
        }
        return@withContext photosToReturn
    }

    override suspend fun savePhoto(photo: PhotoModel) = withContext(Dispatchers.IO) {
        val photoEntity = PhotoEntity(
            id = photo.id,
            url = photo.imageUrl,
            photographer = photo.photographerName,
            src = PhotoSrcEntity(
                portrait = photo.imageUrl,
                original = photo.imageUrl,
                medium = photo.imageUrl,
                large = null,
                tiny = null,
                landscape = null
            )
        )
        dao.insertPhotos(listOf(photoEntity))
    }
}