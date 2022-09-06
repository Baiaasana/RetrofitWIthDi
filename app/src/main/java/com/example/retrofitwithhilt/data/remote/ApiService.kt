package com.example.retrofitwithhilt.data.remote

import com.example.retrofitwithhilt.domain.model.FactModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("fact")
    suspend fun getFacts(): Response<FactModel>
}