package com.example.photogalleryapp.Data.local

import androidx.room.TypeConverter
import com.example.photogalleryapp.domain.models.PhotoModel
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromPhotoSrc(src: PhotoModel): String = Gson().toJson(src)

    @TypeConverter
    fun toPhotoSrc(src: String): PhotoModel = Gson().fromJson(src, PhotoModel::class.java)
}