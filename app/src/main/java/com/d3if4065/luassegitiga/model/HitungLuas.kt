package com.d3if4065.luassegitiga.model

fun LuasHitung.hitungLuas(): HasilLuas {
    val diameter = 0.5
    val luas = diameter * alas * tinggi
    return HasilLuas(luas)
}
