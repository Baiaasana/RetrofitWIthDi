package com.example.retrofitwithhilt.domain.repository

import com.example.retrofitwithhilt.domain.model.FactModelUi
import com.example.retrofitwithhilt.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<FactModelUi>>
}