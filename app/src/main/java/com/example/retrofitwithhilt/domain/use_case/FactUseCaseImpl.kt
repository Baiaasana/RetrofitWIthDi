package com.example.retrofitwithhilt.domain.use_case

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.domain.repository.Repository
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : FactUseCase {

    //    override suspend fun invoke(params: Unit): Flow<Resource<FactModel>> = flow {
//        try {
//            emit(Resource.loading(null))
//            val response = repository.doNetworkCall()
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
    override suspend fun invoke(params: Unit): Flow<Resource<FactModelDTO>> = repository.doNetworkCall()
}