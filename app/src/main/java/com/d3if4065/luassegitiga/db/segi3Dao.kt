package com.d3if4065.luassegitiga.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface segi3Dao {

    @Insert
    fun insert(bmi: Segi3Entity)

    @Query("SELECT * FROM luas-segi3 ORDER BY id DESC LIMIT 1")
    fun getLastsegi3(): LiveData<Segi3Entity>
}