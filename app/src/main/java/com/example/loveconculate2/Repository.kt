package com.example.loveconculate2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.loveconculate2.data.api.LoveApi
import com.example.loveconculate2.data.models.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

    fun getLoveModelMutableLiveData(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val loveModel: MutableLiveData<LoveModel> = MutableLiveData()
        api.getCalculateLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    loveModel.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }
        })
        return loveModel
    }
}