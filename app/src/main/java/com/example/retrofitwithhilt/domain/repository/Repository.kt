package com.example.retrofitwithhilt.domain.repository

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.utility.Resource
import com.example.retrofitwithhilt.utility.Resource2
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<FactModelDTO>>
}