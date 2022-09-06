package com.example.retrofitwithhilt.domain.model

data class FactModel(
    val fact: String?,
    val length: Int?,
) {
    fun toPresentation(): FactModelUi {
        return FactModelUi(
            fact = fact,
            length = length
        )
    }
}
