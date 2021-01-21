package com.example.parkeerautomatenv4.data.remote

import com.bumptech.glide.load.engine.Resource
import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
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
    @GET("api/records/1.0/search/?dataset=locaties-parkeerautomaten-gent&q=&rows=100&facet=parkeertariefzone&facet=bewonerszone&facet=betaalmodus&facet=status&facet=categorie&facet=locatieomschrijving")
    suspend fun getParkeerautomaten(): Response<GetParkeerautomaatApiResponse>
}

object GhentApi {
    val apiService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}
