package io.jyotimoykashyap.apptobenchmark.api

import io.jyotimoykashyap.apptobenchmark.models.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("/photos")
    suspend fun getPhotos() : Response<PhotoResponse>
}