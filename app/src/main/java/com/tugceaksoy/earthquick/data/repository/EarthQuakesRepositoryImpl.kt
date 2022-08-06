package com.tugceaksoy.earthquick.data.repository

import com.tugceaksoy.earthquick.data.model.EarthquakeModel
import com.tugceaksoy.earthquick.data.model.EarthquakeModelItem
import com.tugceaksoy.earthquick.data.model.Output
import com.tugceaksoy.earthquick.data.remote.ServiceAPI
import com.tugceaksoy.earthquick.utils.RetrofitUtils
import retrofit2.Retrofit
import javax.inject.Inject

class EarthQuakesRepositoryImpl @Inject constructor(
    private val retrofit: Retrofit,
    private val serviceApi: ServiceAPI
) :EarthQuakesRepository {
    override suspend fun getEarthQuakes(): Output<EarthquakeModel> {
        val response = serviceApi.getEarthquakes()
        return RetrofitUtils.getResponse(retrofit,{response},"Error")
    }
}