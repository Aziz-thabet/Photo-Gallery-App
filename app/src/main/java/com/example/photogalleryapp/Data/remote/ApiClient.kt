// photogalleryapp/Data/remote/ApiClient.kt
package com.example.photogalleryapp.Data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface PexelsApiService {
    @GET("curated")
    suspend fun getCuratedPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 80
    ): Response<PexelsResponse>
}
