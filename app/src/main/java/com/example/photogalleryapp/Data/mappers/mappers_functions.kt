// photogalleryapp/Data/mappers/PhotoMappers.kt
package com.example.photogalleryapp.Data.mappers

import com.example.photogalleryapp.Data.local.PhotoEntity
import com.example.photogalleryapp.Data.local.PhotoSrcEntity
import com.example.photogalleryapp.Data.remote.Photo as RemotePhoto
import com.example.photogalleryapp.domain.models.PhotoModel

fun RemotePhoto.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        id = this.id,
        url = this.src.original,
        photographer = this.photographer,
        src = PhotoSrcEntity(
            portrait = this.src.portrait,
            original = this.src.original,
            medium = this.src.medium,
            large = this.src.large,
            tiny = this.src.tiny,
            landscape = this.src.landscape
        )
    )
}

fun PhotoEntity.toPhotoModel(): PhotoModel {
    return PhotoModel(
        id = this.id,
        imageUrl = this.src.portrait,
        photographerName = this.photographer
    )
}