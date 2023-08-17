package io.jyotimoykashyap.apptobenchmark.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PhotoResponse(
    val listOfPhotos: List<Photo>
) : Parcelable
