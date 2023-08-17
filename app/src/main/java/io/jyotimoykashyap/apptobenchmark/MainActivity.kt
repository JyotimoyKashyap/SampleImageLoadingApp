package io.jyotimoykashyap.apptobenchmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import io.jyotimoykashyap.apptobenchmark.models.Photo
import io.jyotimoykashyap.apptobenchmark.repository.RestRepository
import io.jyotimoykashyap.apptobenchmark.screens.RandomJsonPlaceholderApiList
import io.jyotimoykashyap.apptobenchmark.ui.theme.AppToBenchmarkTheme
import io.jyotimoykashyap.apptobenchmark.vm.RestViewModel
import io.jyotimoykashyap.apptobenchmark.vm.RestViewModelProviderFactory

class MainActivity : ComponentActivity() {

    lateinit var viewModel: RestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = RestRepository()
        val viewModelProviderFactory = RestViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[RestViewModel::class.java]

        setContent {
            AppToBenchmarkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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