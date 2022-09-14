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

//    override suspend fun doNetworkCall(): Response<FactModelDTO> {
//        return api.getFacts()
//    }

    //        override suspend fun doNetworkCall(): Flow<Resource<FactModel>> = flow {
//        try {
//            emit(Resource.loading(null))
//            val response = api.getFacts()
//            val result = response.body()!!.toPresentation()
//            if (response.isSuccessful) {
//                emit(Resource.success(result))
//            } else {
//                emit(Resource.error(response.message()))
//            }
//        } catch (e: Exception) {
//            emit(Resource.error(e.message.toString()))
//        }
//    }
    override suspend fun doNetworkCall(): Flow<Resource<FactModelDTO>> = flow {
        emit(safeApiCall { api.getFacts() })

    }
}
