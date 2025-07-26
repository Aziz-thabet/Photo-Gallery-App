// photogalleryapp/ApiClient.kt
package com.example.photogalleryapp.Data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface PexelsApiService {
    @GET("curated")
    suspend fun getCuratedPhotos(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<PexelsResponse>
}
