package com.example.retrofitwithhilt.domain.use_case

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.domain.use_case.base.BaseUseCase
import com.example.retrofitwithhilt.domain.use_case.base.BaseUseCaseWithoutParams
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow


//interface FactUseCase : BaseUseCase<Unit, Flow<Resource<FactModelDTO>>> {
//    override suspend operator fun invoke(params: Unit): Flow<Resource<FactModelDTO>>
//}

interface FactUseCase : BaseUseCaseWithoutParams< Flow<Resource<FactModelDTO>>> {
    override suspend operator fun invoke(): Flow<Resource<FactModelDTO>>
}

