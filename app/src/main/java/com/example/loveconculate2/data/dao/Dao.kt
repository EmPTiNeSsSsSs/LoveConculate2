package com.example.loveconculate2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.loveconculate2.data.models.LoveModel

interface Dao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_model ORDER by firstName ASC")
    fun getAll(): LiveData<List<LoveModel>>

}