package com.example.retrofitwithhilt.utility

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel

data class FactViewState(
    val isLoading: Boolean = false,
    val data: FactModelDTO = FactModelDTO("", 0),
    val errorMessage: String = "",
)


data class BaseViewState<T>(
    val isLoading: Boolean = false,
    val data: Any? = null,
    val errorMessage: String = "",
) {

}