package com.example.retrofitwithhilt.presenter.facts

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithhilt.common.BaseViewModel
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.use_case.FactUseCaseImpl
import com.example.retrofitwithhilt.utility.FactViewState
import com.example.retrofitwithhilt.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val factUseCaseImpl: FactUseCaseImpl,
) : BaseViewModel() {

//    private val _factFlow = MutableStateFlow<FactViewState>(FactViewState())
//    val factFlow = _factFlow.asStateFlow()

    suspend fun getFacts() {
        resetState()
        responseHandler(factUseCaseImpl.invoke())

//        viewModelScope.launch {
//            val data = factUseCaseImpl.invoke()
//            data.collect {
//                when (it.status) {
//                    Resource.Status.SUCCESS -> {
//                        val result = (it.data as FactModelDTO)
//                        _factFlow.value = _factFlow.value.copy(isLoading = false, data = it.data)
//                        d("log1", " success - $result")
//                    }
//                    Resource.Status.ERROR -> {
//                        _factFlow.value = _factFlow.value.copy(isLoading = false,
//                            errorMessage = it.message.toString())
//                        d("log1", "error")
//                    }
//                    Resource.Status.LOADING -> {
//                        _factFlow.value = _factFlow.value.copy(isLoading = true)
//                        d("log1", "loading")
//                    }
//                }
//            }
//        }
    }

    private fun resetState() {
        _factFlow.value = _factFlow.value.copy(
            isLoading = false,
            data = FactModelDTO("", 0),
            errorMessage = "",
        )
    }
}