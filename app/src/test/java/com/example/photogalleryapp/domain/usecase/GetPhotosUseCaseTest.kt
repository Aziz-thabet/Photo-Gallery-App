package com.example.photogalleryapp.domain.usecase

import org.junit.Assert.*


import com.example.photogalleryapp.domain.models.PhotoModel
import com.example.photogalleryapp.domain.repository.PhotoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class GetPhotosUseCaseTest {

    private lateinit var mockPhotoRepository: PhotoRepository
    private lateinit var getPhotosUseCase: GetPhotosUseCase

    @Before
    fun setup() {
        mockPhotoRepository = mockk()
        getPhotosUseCase = GetPhotosUseCase(mockPhotoRepository)
    }

    @Test
    fun `invoke returns photos from repository when successful`() = runTest {
        val expectedPhotos = listOf(
            PhotoModel(1, "url1", "Photographer 1"),
            PhotoModel(2, "url2", "Photographer 2")
        )

        coEvery { mockPhotoRepository.getPhotos(any()) } returns expectedPhotos

        val result = getPhotosUseCase(forceRefresh = true)

        assertEquals(expectedPhotos, result)
    }

    @Test
    fun `invoke throws exception when repository fails`() = runTest {
        val errorMessage = "Network error"
        coEvery { mockPhotoRepository.getPhotos(any()) } throws RuntimeException(errorMessage)

        assertFailsWith<RuntimeException> {
            getPhotosUseCase(forceRefresh = true)
        }
    }

    @Test
    fun `invoke passes forceRefresh parameter correctly`() = runTest {
        val expectedPhotos = listOf(PhotoModel(1, "url1", "Photographer 1"))

        coEvery { mockPhotoRepository.getPhotos(true) } returns expectedPhotos
        val resultTrue = getPhotosUseCase(forceRefresh = true)
        assertEquals(expectedPhotos, resultTrue)

        coEvery { mockPhotoRepository.getPhotos(false) } returns expectedPhotos
        val resultFalse = getPhotosUseCase(forceRefresh = false)
        assertEquals(expectedPhotos, resultFalse)
    }
}
