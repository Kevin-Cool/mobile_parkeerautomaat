package com.example.parkeerautomatenv4.data.remote

import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.stad.gent/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val client = OkHttpClient.Builder().build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

interface GhentApiService{
    @GET("api/records/1.0/search/?dataset=locaties-parkeerautomaten-gent&q=&rows=-1")
    suspend fun getParkeerautomaten(): GetParkeerautomaatApiResponse
}

object GhentApi {
    val apiService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}
