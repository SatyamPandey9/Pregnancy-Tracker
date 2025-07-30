package com.project.satyam.preganancytester.ui.component.vitals.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.satyam.preganancytester.model.VitalsData
import com.project.satyam.preganancytester.repository.VitalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VitalsViewModel @Inject constructor(
    private val repository: VitalsRepository
) : ViewModel() {

    private val _vitals = MutableStateFlow<List<VitalsData>>(emptyList())
    val vitals: StateFlow<List<VitalsData>> = _vitals.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllVitals().collect {
                _vitals.value = it
            }
        }
    }

    fun addVitals(data: VitalsData) {
        viewModelScope.launch {
            repository.insertVitals(data)
        }
    }

}


