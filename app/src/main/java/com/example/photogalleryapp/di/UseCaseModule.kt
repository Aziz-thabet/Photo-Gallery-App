package com.example.photogalleryapp.di
import com.example.photogalleryapp.domain.repository.PhotoRepositoryDomain // واجهة الـ Domain
import com.example.photogalleryapp.domain.usecase.GetPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(photoRepository: PhotoRepositoryDomain): GetPhotosUseCase {
        return GetPhotosUseCase(photoRepository)
    }
}