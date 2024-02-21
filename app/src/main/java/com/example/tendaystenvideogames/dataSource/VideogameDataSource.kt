package com.example.tendaystenvideogames.dataSource

import com.example.tendaystenvideogames.R
import com.example.tendaystenvideogames.model.Videogame

class VideogamesDataSource {
    fun getVideogames(): List<Videogame> {
        return listOf(
            Videogame(
                nameRes = R.string.titulo_juego1,
                descriptionRes = R.string.descripcion_juego1,
                imageRes = R.drawable._01elden_ring,
                webPageRes = R.string.webPage_juego1
            ),
            Videogame(
                nameRes = R.string.titulo_juego2,
                descriptionRes = R.string.descripcion_juego2,
                imageRes = R.drawable._02fortnite,
                webPageRes = R.string.webPage_juego2
            ),
            Videogame(
                nameRes = R.string.titulo_juego3,
                descriptionRes = R.string.descripcion_juego3,
                imageRes = R.drawable._03gta,
                webPageRes = R.string.webPage_juego3
            ),
            Videogame(
                nameRes = R.string.titulo_juego4,
                descriptionRes = R.string.descripcion_juego4,
                imageRes = R.drawable._04krunker,
                webPageRes = R.string.webPage_juego4
            ),
            Videogame(
                nameRes = R.string.titulo_juego5,
                descriptionRes = R.string.descripcion_juego5,
                imageRes = R.drawable._05smite,
                webPageRes = R.string.webPage_juego5
            ),
            Videogame(
                nameRes = R.string.titulo_juego6,
                descriptionRes = R.string.descripcion_juego6,
                imageRes = R.drawable._06tarkov,
                webPageRes = R.string.webPage_juego6
            ),
            Videogame(
                nameRes = R.string.titulo_juego7,
                descriptionRes = R.string.descripcion_juego7,
                imageRes = R.drawable._07tekken,
                webPageRes = R.string.webPage_juego7
            ),
            Videogame(
                nameRes = R.string.titulo_juego8,
                descriptionRes = R.string.descripcion_juego8,
                imageRes = R.drawable._08the_witcher,
                webPageRes = R.string.webPage_juego8
            ),
            Videogame(
                nameRes = R.string.titulo_juego9,
                descriptionRes = R.string.descripcion_juego9,
                imageRes = R.drawable._09xcom,
                webPageRes = R.string.webPage_juego9
            ),
            Videogame(
                nameRes = R.string.titulo_juego10,
                descriptionRes = R.string.descripcion_juego10,
                imageRes = R.drawable._10splatoon,
                webPageRes = R.string.webPage_juego10
            )
        )
    }
}