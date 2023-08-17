package io.jyotimoykashyap.apptobenchmark.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.jyotimoykashyap.apptobenchmark.repository.RestRepository

class RestViewModelProviderFactory(val restRepository: RestRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RestViewModel(restRepository = restRepository) as T
    }
}