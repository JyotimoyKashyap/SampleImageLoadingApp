package io.jyotimoykashyap.apptobenchmark.screens


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.jyotimoykashyap.apptobenchmark.models.Photo


@Composable
fun RandomJsonPlaceholderApiList(
    photos: List<Photo>
) {
    Surface {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(photos) { photo ->
                PhotoCard(imageUrl = photo.url)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowItem(
    imageUrl: String,
    albumTitle: String
) {
    Card(
        onClick = { /* do nothing */ },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "album thumbnail compressed",
                modifier = Modifier.size(150.dp, 150.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = albumTitle,
                fontSize = 22.sp
            )
        }
    }
}


@Composable
fun PhotoCard(
    imageUrl: String
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Image",
        modifier = Modifier.size(200.dp, 200.dp)
    )
}

@Preview
@Composable
fun RowItemPreview() {
    val imageUrl = "https://via.placeholder.com/600/92c952"
    val albumTitle = "Lorem Ipsum Solati fhifdifjdfoisdjodsjfdsjfodjsffdijfsojfsd"
    RowItem(
        imageUrl = imageUrl,
        albumTitle = albumTitle
    )
}

@Preview
@Composable
fun PhotoCardPreview() {
    val imageUrl = "https://via.placeholder.com/600/92c952"
    PhotoCard(imageUrl = imageUrl)
}

@Preview
@Composable
fun PreviewView() {
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
    Surface {
        RandomJsonPlaceholderApiList(listOfPhotos)
    }
}