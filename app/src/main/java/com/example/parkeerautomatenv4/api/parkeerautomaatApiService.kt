package com.example.parkeerautomatenv4.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://data.stad.gent/api/records/1.0/search/?dataset=locaties-parkeerautomaten-gent";

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()


interface parkeerautomaatApiService {
    @GET("&q=&rows=-1")
    suspend fun getparkeerautomaten() : parkeerautomaten

    @GET("&q=&rows=-1 search?&refine.categorie=")
    suspend fun sorteerCategorie(searchedText : String) : parkeerautomaten
}

object parkeerautomaatApi {
    val retrofitService: parkeerautomaatApiService by lazy {
        retrofit.create(parkeerautomaatApiService::class.java)
    }
}
