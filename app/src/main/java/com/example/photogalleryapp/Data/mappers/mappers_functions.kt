// photogalleryapp/Data/mappers/PhotoMappers.kt
package com.example.photogalleryapp.Data.mappers

import com.example.photogalleryapp.Data.local.PhotoEntity
import com.example.photogalleryapp.domain.models.PhotoModel
fun PhotoEntity.toPhotoModel(): PhotoModel {
    return PhotoModel(
        id = this.id,
        imageUrl = this.src.portrait,
        photographerName = this.photographer
    )
}