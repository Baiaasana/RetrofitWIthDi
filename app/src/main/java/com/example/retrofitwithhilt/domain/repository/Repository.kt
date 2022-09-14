package com.example.retrofitwithhilt.domain.repository

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<FactModelDTO>>
}