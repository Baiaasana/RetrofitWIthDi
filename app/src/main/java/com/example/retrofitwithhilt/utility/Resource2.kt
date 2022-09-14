package com.example.retrofitwithhilt.utility

sealed class Resource2<T>(){
    data class Success<T: Any>(val data: T? = null):Resource2<T>()
    data class Error<T>(val errorMessage: String):Resource2<T>()
    class Loading<T>:Resource2<Nothing>()
}