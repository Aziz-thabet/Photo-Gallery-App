// photogalleryapp/ApiClient.kt
package com.example.photogalleryapp.Data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

object ApiClient {
    private const val BASE_URL = "https://api.pexels.com/v1/"
    private const val API_KEY = "a51pl0H9bNh0N7S4IrGYpgxnUChStb3BrZioTySQv8DmQqJb6M3sWpPi"

    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", API_KEY)
            .build()
        chain.proceed(request)
    }.build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val pexelsApiService: PexelsApiService = retrofit.create(PexelsApiService::class.java)
}

interface PexelsApiService {
    @GET("curated")
    suspend fun getCuratedPhotos(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<PexelsResponse>
}
