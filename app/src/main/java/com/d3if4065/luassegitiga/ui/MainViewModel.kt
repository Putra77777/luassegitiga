package com.d3if4065.luassegitiga.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if4065.luassegitiga.model.HasilLuas
import com.d3if4065.luassegitiga.model.LuasHitung
import com.d3if4065.luassegitiga.model.hitungLuas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val hasilLuas = MutableLiveData<HasilLuas?>()

    fun luasHitung(alas: Double, tinggi: Double) {
        val dataLuasSegitiga = LuasHitung(
            alas = alas,
            tinggi = tinggi
        )
        hasilLuas.value = dataLuasSegitiga.hitungLuas()
    }

    fun getHasilLuas(): LiveData<HasilLuas?> = hasilLuas

}