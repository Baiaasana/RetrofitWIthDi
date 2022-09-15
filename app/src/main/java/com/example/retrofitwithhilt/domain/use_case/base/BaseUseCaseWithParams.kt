package com.example.retrofitwithhilt.domain.use_case.base

interface BaseUseCase<Params, Result> {
    suspend fun invoke(params: Params): Result
}