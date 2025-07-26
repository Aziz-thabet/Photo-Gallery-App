package com.example.photogalleryapp.Data.remote

data class PexelsResponse(
    val photos: List<Photo>
)

data class Photo(
    val id: Int,
    val photographer: String,
    val src: PhotoSrc
)

data class PhotoSrc(
    val original: String,
    val medium: String,
    val portrait: String,
    val large: String?,
    val tiny: String?,
    val landscape: String?
)