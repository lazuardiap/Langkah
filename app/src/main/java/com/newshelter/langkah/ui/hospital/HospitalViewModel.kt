package com.newshelter.langkah.ui.hospital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import com.newshelter.langkah.ui.home.modelhome.Result
import com.newshelter.langkah.ui.hospital.modelroute.Route
import com.newshelter.langkah.ui.hospital.modelroute.RouteResponses
import com.newshelter.langkah.utils.retrofit.ApiRetrofit
import com.newshelter.langkah.utils.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HospitalViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Hospital"
    }
    val text: LiveData<String> = _text


    val liveRoute = MutableLiveData<ArrayList<Route>>()

    fun getLiveDirection():LiveData<ArrayList<Route>>{
        return liveRoute
    }




    fun getDirection(nowLocation:String,goalLocation:String){
        val array = ArrayList<Route>()
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getDirection(nowLocation,goalLocation).enqueue(object :Callback<RouteResponses>{
            override fun onResponse(
                call: Call<RouteResponses>,
                response: Response<RouteResponses>
            ) {
                array.addAll(response.body()?.routes!!)
                liveRoute.postValue(array)
            }

            override fun onFailure(call: Call<RouteResponses>, t: Throwable) {

            }

        })
        liveRoute.postValue(array)
    }

}