// photogalleryapp/data/repository/PhotoRepository.kt
package com.example.photogalleryapp.data.repository
import com.example.photogalleryapp.domain.models.PhotoModel
import com.example.photogalleryapp.domain.repository.PhotoRepository as DomainPhotoRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log
import com.example.photogalleryapp.Data.local.PhotoDao
import com.example.photogalleryapp.Data.local.PhotoEntity
import com.example.photogalleryapp.Data.local.PhotoSrcEntity
import com.example.photogalleryapp.Data.mappers.toPhotoEntity
import com.example.photogalleryapp.Data.mappers.toPhotoModel
import com.example.photogalleryapp.Data.remote.PexelsApiService

class PhotoRepository(
    private val dao: PhotoDao,
    private val pexelsApiService: PexelsApiService
) : DomainPhotoRepository {

    override suspend fun getPhotos(forceRefresh: Boolean): List<PhotoModel> = withContext(Dispatchers.IO) {
        var photosToDisplay: List<PhotoModel> = emptyList()

        try {
            if (forceRefresh) {
                val response = pexelsApiService.getCuratedPhotos(perPage = 30, page = 1)
                if (response.isSuccessful) {
                    val pexelsResponse = response.body()
                    pexelsResponse?.let {
                        val photoEntities = it.photos.map { remotePhoto -> remotePhoto.toPhotoEntity() }
                        dao.deleteAll()
                        dao.insertPhotos(photoEntities)
                        photosToDisplay = photoEntities.map { entity -> entity.toPhotoModel() }
                    } ?: run {
                        Log.e("PhotoRepository", "API response body is null.")
                    }
                } else {
                    Log.e("PhotoRepository", "API call failed with code: ${response.code()}, message: ${response.message()}")
                }
            }

            if (photosToDisplay.isEmpty()) {
                val savedPhotos = dao.getAllPhotos()
                if (savedPhotos.isNotEmpty()) {
                    photosToDisplay = savedPhotos.map { it.toPhotoModel() }
                } else {
                    Log.d("PhotoRepository", "Local database is empty and no photos from API.")
                }
            }
        } catch (e: Exception) {
            Log.e("PhotoRepository", "Error fetching photos: ${e.message}", e)
            photosToDisplay = dao.getAllPhotos().map { it.toPhotoModel() }
        }
        return@withContext photosToDisplay
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