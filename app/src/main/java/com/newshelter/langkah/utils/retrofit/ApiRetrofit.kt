package com.newshelter.langkah.utils.retrofit

import com.newshelter.langkah.BuildConfig
import com.newshelter.langkah.ui.home.modelhome.PlaceResponses
import com.newshelter.langkah.ui.hospital.modelroute.RouteResponses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofit {
    //AIzaSyDLXDQiumBLhSh0OB5D7biGcQL7PbhSY-w ${BuildConfig.KEY}

    @GET("maps/api/place/nearbysearch/json?radius=1000&type=hospital&key=${BuildConfig.KEY}")
    fun getNearbyHospital(@Query("location")locationNow:String): Call<PlaceResponses>


        @GET("maps/api/directions/json?key=${BuildConfig.KEY}")
        fun getDirection(@Query("origin") origin: String,
                         @Query("destination") destination: String): Call<RouteResponses>


 //   @GET("details/json?place_id=ChIJN1t_tDeuEmsRUsoyG83frY4&fields=name,rating,formatted_phone_number&key=${BuildConfig.KEY}")
  //  fun getDetailHospital(@Query("place_id")numberId:String):Call


   // https://maps.googleapis.com/maps/api/place/
//"https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&maxheight=100&photoreference=${photoLit}&key=${BuildConfig.KEY}"
  //  @GET("textsearch/json?radius=1000&key=${BuildConfig.KEY}")
   // fun getSearchHospital(@Query("location")locationNow:String,@Query("query")query:String) :Call<ArrayList<GoogleHospitalEntity>>
}