package com.azmarzly.meals.model

sealed class MealRating(val value: Float) {
    object Zero : MealRating(0f)
    object One : MealRating(1f)
    object Two : MealRating(2f)
    object Three : MealRating(3f)
    object Four : MealRating(4f)
    object Five : MealRating(5f)
    object Six : MealRating(6f)
    object Seven : MealRating(7f)
    object Eight : MealRating(8f)
    object Nine : MealRating(9f)
    object Ten : MealRating(10f)
}