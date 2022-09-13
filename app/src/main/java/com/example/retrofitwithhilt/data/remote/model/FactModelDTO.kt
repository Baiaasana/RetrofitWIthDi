package com.example.retrofitwithhilt.data.remote.model

import com.example.retrofitwithhilt.domain.model.FactModel

data class FactModelDTO(
    val fact: String?,
    val length: Int?,
) {
    fun toPresentation(): FactModel {
        return FactModel(
            fact = fact,
            length = length
        )
    }
}
