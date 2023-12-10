package com.example.myapplication.zad1

import androidx.annotation.DrawableRes

data class Ingredient(
    @DrawableRes val imageResource : Int,
    val title : String,
    val subtitle : String
)
