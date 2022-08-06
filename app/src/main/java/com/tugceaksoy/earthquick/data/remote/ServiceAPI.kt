package com.tugceaksoy.earthquick.data.remote

import com.tugceaksoy.earthquick.data.model.EarthquakeModel
import com.tugceaksoy.earthquick.data.model.EarthquakeModelItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ServiceAPI{
    @GET("api")
   suspend fun getEarthquakes() : Response<EarthquakeModel>



}