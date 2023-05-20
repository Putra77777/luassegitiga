package com.d3if4065.luassegitiga.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "luas_segi3")
data class Segi3Entity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var alas: Float,
    var tinggi: Float,
)