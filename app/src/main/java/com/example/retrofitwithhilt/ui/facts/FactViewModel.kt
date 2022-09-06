package com.example.retrofitwithhilt.ui.facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithhilt.domain.model.FactModelUi
import com.example.retrofitwithhilt.domain.repository.Repository
import com.example.retrofitwithhilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _factFlow = MutableStateFlow<Resource<FactModelUi>>(Resource.loading(null))
    val factFlow = _factFlow.asStateFlow()

    fun getFacts() {
        viewModelScope.launch {
            val data = repository.doNetworkCall()
            data.collect {
                _factFlow.value = it
            }
        }
    }
}