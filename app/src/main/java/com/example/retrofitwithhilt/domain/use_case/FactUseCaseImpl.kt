package com.example.retrofitwithhilt.domain.use_case

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.repository.Repository
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactUseCaseImpl @Inject constructor(
    private val repository: Repository,
)  {

     suspend fun invoke(): Flow<Resource<FactModelDTO>> = repository.doNetworkCall()
}