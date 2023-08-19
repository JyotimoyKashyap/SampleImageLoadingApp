package io.jyotimoykashyap.apptobenchmark.vm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jyotimoykashyap.apptobenchmark.models.Photo
import io.jyotimoykashyap.apptobenchmark.repository.RestRepository
import io.jyotimoykashyap.apptobenchmark.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class RestViewModel(
    private val restRepository: RestRepository
) : ViewModel() {
    private val _photos : MutableLiveData<Resource<List<Photo>>> = MutableLiveData()
    val photos = _photos


    fun getPhotos() = viewModelScope.launch {
        _photos.postValue(Resource.Loading())

        // network call
        val response = restRepository.getPhotos()
        _photos.postValue(handleRestResponse(response))
    }

    private fun handleRestResponse(response: Response<List<Photo>>) : Resource<List<Photo>> {
        if(response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }

        return Resource.Error(response.message())
    }
}