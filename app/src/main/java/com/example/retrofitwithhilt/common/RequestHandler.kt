package com.example.retrofitwithhilt.common

import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.utility.Resource
import retrofit2.Response

 abstract class RequestHandler {

    suspend fun <T: Any> safeApiCall(request: suspend () -> Response<T>): Resource<T> =

        try {
            Resource.loading(null)
            val response = request.invoke()
            val result = response.body()!!
            if (response.isSuccessful) {
                Resource.success(result)
            } else {
                Resource.error(response.message())
            }
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }


