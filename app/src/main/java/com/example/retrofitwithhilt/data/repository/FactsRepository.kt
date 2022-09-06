package com.example.retrofitwithhilt.data.repository

import com.example.retrofitwithhilt.data.remote.ApiService
import com.example.retrofitwithhilt.domain.model.FactModelUi
import com.example.retrofitwithhilt.domain.repository.Repository
import com.example.retrofitwithhilt.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FactsRepository @Inject constructor(
    private val api: ApiService,
) : Repository {

    override suspend fun doNetworkCall(): Flow<Resource<FactModelUi>> = flow {
        try {
            emit(Resource.loading(null))
            val response = api.getFacts()
            val result = response.body()!!.toPresentation()
            if (response.isSuccessful) {
                emit(Resource.success(result))
            } else {
                emit(Resource.error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString()))
        }
    }
}