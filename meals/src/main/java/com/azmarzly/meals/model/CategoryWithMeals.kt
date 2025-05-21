package com.azmarzly.meals.model

import androidx.compose.ui.graphics.Color

data class CategoryWithMeals(
    val category: MealCategory,
    val meals: List<Meal>,
    val color: Color? = null,
)
