package com.example.retrofitwithhilt.data.remote.repository

import com.example.retrofitwithhilt.data.remote.network.ApiService
import com.example.retrofitwithhilt.domain.repository.Repository
import com.example.retrofitwithhilt.common.RequestHandler
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(
    private val api: ApiService,
) : Repository, RequestHandler() {

    override suspend fun doNetworkCall(): Flow<Resource<FactModelDTO>> = flow {
        emit(Resource.loading())
        emit(safeApiCall { api.getFacts() })

    }
}
