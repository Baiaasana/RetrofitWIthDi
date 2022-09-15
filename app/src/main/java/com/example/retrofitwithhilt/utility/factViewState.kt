package com.example.retrofitwithhilt.utility

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO

data class FactViewState(
    val isLoading: Boolean = false,
    val data: FactModelDTO = FactModelDTO("", 0),
    val errorMessage: String = "",
)


data class BaseViewState<T>(
    val isLoading: Boolean = false,
    val data: T,
    val errorMessage: String = "",
)