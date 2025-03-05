package org.example.project.aplicacion

import Meme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.shared.View.MemeViewModel

@Composable
fun PantallaAPI(navController: NavController) {
    val viewModel = remember { MemeViewModel() }
    val memes by viewModel.memes.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Memes desde la API", fontSize = MaterialTheme.typography.h5.fontSize)

        if (memes.isEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(memes) { meme ->
                    MemeItem(meme)
                }
            }
        }
    }
}


@Composable
fun MemeItem(meme: Meme) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = meme.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            KamelImage(
                resource = asyncPainterResource(meme.url),
                contentDescription = meme.name,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        }
    }
}
