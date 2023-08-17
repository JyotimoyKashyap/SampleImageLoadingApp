package io.jyotimoykashyap.apptobenchmark.ui

import io.jyotimoykashyap.apptobenchmark.models.Photo
import io.jyotimoykashyap.apptobenchmark.models.PhotoResponse

data class MainActivityUiState(
    val data: PhotoResponse? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null
)
