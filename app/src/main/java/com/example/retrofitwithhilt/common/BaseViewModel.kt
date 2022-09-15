package com.example.retrofitwithhilt.common

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.utility.FactViewState
import com.example.retrofitwithhilt.utility.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel() {

    val _factFlow = MutableStateFlow<FactViewState>(FactViewState())
    val factFlow = _factFlow.asStateFlow()

    fun <T> responseHandler(flow: Flow<Resource<T>>) {

        viewModelScope.launch {
            val data = flow.collect {

                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        val result = (it.data as FactModelDTO)
                        _factFlow.value = _factFlow.value.copy(isLoading = false, data = it.data)
                        Log.d("log1", " success - $result")
                    }
                    Resource.Status.ERROR -> {
                        _factFlow.value = _factFlow.value.copy(isLoading = false,
                            errorMessage = it.message.toString())
                        Log.d("log1", "error")
                    }
                    Resource.Status.LOADING -> {
                        _factFlow.value = _factFlow.value.copy(isLoading = true)
                        Log.d("log1", "loading")
                    }
                }
            }
        }
    }
}