package com.azmarzly.meals.model

import java.time.LocalDateTime

data class Meal(
    val id: String,
    val name: String,
    val createdAt: LocalDateTime, // or timestamp?
    val rating: MealRating,
    val categoryIds: List<String>, // to groupBy with the MealCategory.id
    val imageUrl: String,
)