// photogalleryapp/Data/local/PhotoEntity.kt
package com.example.photogalleryapp.Data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey val id: Int,
    val url: String,
    val photographer: String,
    @Embedded(prefix = "src_")
    val src: PhotoSrcEntity
)
data class PhotoSrcEntity(
    val portrait: String,
    val original: String?,
    val medium: String?,
    val large: String?,
    val tiny: String?,
    val landscape: String?
)
