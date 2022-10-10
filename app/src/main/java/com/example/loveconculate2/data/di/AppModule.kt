package com.example.loveconculate2.data.di

import com.example.loveconculate2.data.api.LoveApi
import com.example.loveconculate2.helper.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    fun provideLoveApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences() : SharedPreferences {
        return SharedPreferences()
    }
}