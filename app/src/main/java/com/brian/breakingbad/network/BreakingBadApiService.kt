package com.brian.breakingbad.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.breakingbadapi.com/api/character/"

//Moshi converter
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit builder
private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


//interface with API methods

interface BreakingBadApiService {
    @GET("random")
   suspend fun getRandomCharacter() : MutableList<CharacterItem>
}

//singleton object for the API service
object BreakingBadAPi {
    val retrofitService: BreakingBadApiService by lazy {
        retrofit.create(BreakingBadApiService::class.java)
    }
}