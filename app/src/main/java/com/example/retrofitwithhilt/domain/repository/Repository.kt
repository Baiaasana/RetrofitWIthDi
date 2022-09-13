package com.example.retrofitwithhilt.domain.repository

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import retrofit2.Response

interface Repository {
    suspend fun doNetworkCall(): Response<FactModelDTO>
}