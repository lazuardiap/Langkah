package com.newshelter.langkah.ui.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newshelter.langkah.ui.home.modelhome.PlaceResponses
import com.newshelter.langkah.ui.home.modelhome.Result
import com.newshelter.langkah.utils.retrofit.ApiRetrofit
import com.newshelter.langkah.utils.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel:ViewModel() {

    val result = MutableLiveData<ArrayList<Result>>()
    fun getLiveResult():LiveData<ArrayList<Result>>{
        return result
    }


    fun getDetailMaps(placeId:String,context: Context){

    }


    fun getListMaps(context: Context)  {
        val array = ArrayList<Result>()
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getNearbyHospital("-6.194031, 106.832587").enqueue(object : Callback<PlaceResponses>{
            override fun onResponse(
                call: Call<PlaceResponses>,
                response: Response<PlaceResponses>
            ) {
                if(response.body() != null){

                    //response.body()?.results?.let { result.addAll(it) }
                    array.addAll(response.body()?.results!!)
                    result.postValue(array)

                }
            }

            override fun onFailure(call: Call<PlaceResponses>, t: Throwable) {
                Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show()
                Log.d(context.toString(),"gagal")
            }
        })
        result.postValue(array)
    }
}



