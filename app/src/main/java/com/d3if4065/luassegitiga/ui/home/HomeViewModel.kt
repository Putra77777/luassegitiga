package com.d3if4065.luassegitiga.home

import androidx.lifecycle.ViewModel
import com.d3if4065.luassegitiga.model.HasilLuas

class HomeViewModel : ViewModel() {

    fun luasHitung (Alas:Float, Tinggi:Float ): HasilLuas {
        val diameter = 0.5
        val luas = diameter * Alas * Tinggi
        return HasilLuas(luas)
    }
}