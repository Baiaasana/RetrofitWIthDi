package com.example.retrofitwithhilt.presenter.facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.domain.use_case.FactUseCase
import com.example.retrofitwithhilt.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val factUseCase: FactUseCase,
) : ViewModel() {

    private val _factFlow = MutableStateFlow<Resource<FactModelDTO>>(Resource.loading(null))
    val factFlow = _factFlow.asStateFlow()

    fun getFacts() {
        viewModelScope.launch {
            val data = factUseCase(Unit)
            data.collect {
                _factFlow.value = it
            }
        }
    }
}