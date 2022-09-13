package com.example.retrofitwithhilt.data.remote.repository

import com.example.retrofitwithhilt.data.remote.network.ApiService
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(
    private val api: ApiService,
) : Repository {

    override suspend fun doNetworkCall(): Response<FactModelDTO> {
        return api.getFacts()
    }

    //    override suspend fun doNetworkCall(): Flow<Resource<FactModelUi>> = flow {
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

}
