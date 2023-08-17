package io.jyotimoykashyap.apptobenchmark.vm

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jyotimoykashyap.apptobenchmark.models.PhotoResponse
import io.jyotimoykashyap.apptobenchmark.repository.RestRepository
import io.jyotimoykashyap.apptobenchmark.ui.MainActivityUiState
import io.jyotimoykashyap.apptobenchmark.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class RestViewModel(
    private val restRepository: RestRepository
) : ViewModel() {
    private val photos : MutableLiveData<Resource<PhotoResponse>> = MutableLiveData()



    fun getPhotos() = viewModelScope.launch {
        photos.postValue(Resource.Loading())

        // network call
        val response = restRepository.getPhotos()
        photos.postValue(handleRestResponse(response))
    }

    private fun handleRestResponse(response: Response<PhotoResponse>) : Resource<PhotoResponse> {
        if(response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }

        return Resource.Error(response.message())
    }
}