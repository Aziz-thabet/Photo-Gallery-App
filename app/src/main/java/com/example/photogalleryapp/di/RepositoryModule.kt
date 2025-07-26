package com.example.photogalleryapp.di

import com.example.photogalleryapp.Data.local.PhotoDao
import com.example.photogalleryapp.Data.remote.PexelsApiService
import com.example.photogalleryapp.data.repository.PhotoRepository
import com.example.photogalleryapp.domain.repository.PhotoRepositoryDomain as DomainPhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePhotoRepository(
        photoDao: PhotoDao,
        pexelsApiService: PexelsApiService
    ): DomainPhotoRepository {
        return PhotoRepository(photoDao, pexelsApiService)
    }
}