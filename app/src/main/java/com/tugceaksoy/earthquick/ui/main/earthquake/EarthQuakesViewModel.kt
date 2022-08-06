package com.tugceaksoy.earthquick.ui.main.earthquake

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tugceaksoy.earthquick.data.model.EarthquakeModel
import com.tugceaksoy.earthquick.data.model.Output
import com.tugceaksoy.earthquick.data.repository.EarthQuakesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EarthQuakesViewModel  @Inject constructor(
    private val repository: EarthQuakesRepository
) : ViewModel(){
    val postQuakes: MutableLiveData<Output<EarthquakeModel>> by lazy {
        MutableLiveData<Output<EarthquakeModel>>()
    }
    suspend fun getEarthQuakes() {
        postQuakes.postValue(Output.loading(null))
        val response = repository.getEarthQuakes()
        postQuakes.postValue(response)
    }
}