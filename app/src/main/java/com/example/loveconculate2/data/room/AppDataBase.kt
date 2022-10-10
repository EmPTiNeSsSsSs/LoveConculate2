package com.example.loveconculate2.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loveconculate2.data.dao.Dao
import com.example.loveconculate2.data.models.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun loveDao(): Dao

}