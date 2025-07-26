package com.example.photogalleryapp.Data.remote

import com.google.gson.annotations.SerializedName

data class PexelsResponse(
    val photos: List<PhotoRemote>,
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int
)

data class PhotoRemote(
    val id: Int,
    val photographer: String,
    val src: PhotoSrcRemote
)

data class PhotoSrcRemote(
    val original: String,
    val large: String?,
    @SerializedName("large2x")
    val large2x: String?,
    val medium: String,
    val small: String?,
    val portrait: String,
    val landscape: String?,
    val tiny: String?
)