package io.jyotimoykashyap.apptobenchmark.repository

import io.jyotimoykashyap.apptobenchmark.api.RetrofitInstance

class RestRepository {
    suspend fun getPhotos() =
        RetrofitInstance.api.getPhotos()
}