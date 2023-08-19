package io.jyotimoykashyap.apptobenchmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.jyotimoykashyap.apptobenchmark.models.Photo
import io.jyotimoykashyap.apptobenchmark.repository.RestRepository
import io.jyotimoykashyap.apptobenchmark.screens.RandomJsonPlaceholderApiList
import io.jyotimoykashyap.apptobenchmark.ui.theme.AppToBenchmarkTheme
import io.jyotimoykashyap.apptobenchmark.vm.RestViewModel

class MainActivity : ComponentActivity() {
    private val repository = RestRepository()
    private val viewModel by viewModels<RestViewModel> {
        viewModelFactory {
            initializer {
                RestViewModel(
                    restRepository = repository
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppToBenchmarkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val photos = viewModel.photos.observeAsState()

                    LaunchedEffect(Unit) {
                        viewModel.getPhotos()
                    }

                    if (photos.value?.data?.isEmpty() == true) {
                        CircularProgressIndicator()
                    } else {
                        photos.value?.data?.let {
                            RandomJsonPlaceholderApiList(photos = it)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val listOfPhotos = listOf<Photo>(
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        ),
        Photo(
            albumId = 1,
            id = 1,
            title = "Mary on a cross",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/600/92c952"
        )
    )
    AppToBenchmarkTheme {
        RandomJsonPlaceholderApiList(photos = listOfPhotos)
    }
}