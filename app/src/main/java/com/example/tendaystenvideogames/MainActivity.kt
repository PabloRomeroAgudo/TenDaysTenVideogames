package com.example.tendaystenvideogames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tendaystenvideogames.dataSource.VideogamesDataSource
import com.example.tendaystenvideogames.ui.theme.TenDaysTenVideogamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenDaysTenVideogamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VideogameApp()
                }
            }
        }
    }
}

val videogames = VideogamesDataSource().getVideogames()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideogameApp() {
    Scaffold(
        topBar = {
            VideogameTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(videogames) {
                VideogameItem(
                    videogame = it,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.card_padding_big),
                        end = dimensionResource(id = R.dimen.card_padding_big),
                        top = dimensionResource(id = R.dimen.card_padding_small)
                    )
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun VideogamesPreview() {
    TenDaysTenVideogamesTheme {
        VideogameApp()
    }
}

@Preview(showBackground = true)
@Composable
fun VideogamesDarkPreview() {
    TenDaysTenVideogamesTheme(darkTheme = true) {
        VideogameApp()
    }
}