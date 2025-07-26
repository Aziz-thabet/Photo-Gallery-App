package com.example.photogalleryapp.Data.local

import android.content.Context
import androidx.room.*

@Database(entities = [PhotoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoDatabase? = null

        fun getInstance(context: Context): PhotoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoDatabase::class.java,
                    "photo_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
