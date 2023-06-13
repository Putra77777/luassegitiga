package com.d3if4065.luassegitiga.network

import com.d3if4065.luassegitiga.model.Glosarium
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL ="https://gist.githubusercontent.com/Putra77777/7fd67f4d4e67abc6c7ee322f0bf9b892/raw/0ffa762ccb007be7748ac9858f0e45749a7a18ba/tubes.json"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Segi3ApiService {

    @GET("tubes.json")
    suspend fun getSegi3(): List<Glosarium>
}

object Segi3Api {
    val service: Segi3ApiService by lazy {
        retrofit.create(Segi3ApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }