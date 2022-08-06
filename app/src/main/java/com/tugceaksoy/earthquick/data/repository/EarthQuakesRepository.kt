package com.tugceaksoy.earthquick.data.repository

import com.tugceaksoy.earthquick.data.model.EarthquakeModel
import com.tugceaksoy.earthquick.data.model.Output

interface EarthQuakesRepository {
    suspend fun getEarthQuakes(): Output<EarthquakeModel>
}