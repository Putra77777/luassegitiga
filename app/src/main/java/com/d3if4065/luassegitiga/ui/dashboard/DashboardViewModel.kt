package com.d3if4065.luassegitiga.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if4065.luassegitiga.model.Glosarium
import com.d3if4065.luassegitiga.network.ApiStatus
import com.d3if4065.luassegitiga.network.Segi3Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val data = MutableLiveData<List<Glosarium>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()

    }

    fun getData(): LiveData<List<Glosarium>> = data



    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(Segi3Api.service.getSegi3())
                status.postValue(ApiStatus.SUCCESS)

            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)

            }
        }
    }

    fun getStatus(): LiveData<ApiStatus> = status
}