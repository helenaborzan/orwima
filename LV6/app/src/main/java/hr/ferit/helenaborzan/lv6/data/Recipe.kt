package com.example.myapplication.zad1

import androidx.annotation.DrawableRes
import hr.ferit.helenaborzan.lv6.R

data class Recipe(
    @DrawableRes val imageResource : Int,
    val title : String,
    val category : String,
    val cookingTime : String,
    val energy : String,
    val rating : String,
    val description : String,
    val reviews: String,
    val ingredients : List<Ingredient>
)

