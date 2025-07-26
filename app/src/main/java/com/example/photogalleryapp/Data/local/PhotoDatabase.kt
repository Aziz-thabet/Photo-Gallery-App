package com.example.photogalleryapp.Data.local

import android.content.Context
import androidx.room.*

@Database(entities = [PhotoEntity::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoDatabase? = null
    }
}
