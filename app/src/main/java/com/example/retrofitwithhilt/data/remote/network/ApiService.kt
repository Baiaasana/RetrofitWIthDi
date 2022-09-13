package com.example.retrofitwithhilt.data.remote.network

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("fact")
    suspend fun getFacts(): Response<FactModelDTO>
}