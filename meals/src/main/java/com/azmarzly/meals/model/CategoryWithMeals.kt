package com.azmarzly.meals.model

data class CategoryWithMeals(
    val category: MealCategory,
    val meals: List<Meal>,
)
