package com.azmarzly.meals.model

import androidx.compose.ui.graphics.Color

data class MealCategory(
    val id: String,
    val name: String,
    val color: Color? = null,
)
