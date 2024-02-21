package com.example.tendaystenvideogames.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Videogame (
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int,
    @StringRes val webPageRes: Int
)