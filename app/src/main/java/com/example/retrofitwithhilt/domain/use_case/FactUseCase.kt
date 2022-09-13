package com.example.retrofitwithhilt.domain.use_case

import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.domain.use_case.base.BaseUseCase
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.Flow

interface FactUseCase : BaseUseCase<Unit, Flow<Resource<FactModel>>> {
    override suspend operator fun invoke(params: Unit): Flow<Resource<FactModel>>
}