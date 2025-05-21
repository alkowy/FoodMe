package com.azmarzly.meals

import com.azmarzly.core.Resource
import com.azmarzly.meals.model.Meal

interface MealsRepository {

    suspend fun addMeal(meal: Meal): Resource<Unit>
    suspend fun updateMeal(meal: Meal): Resource<Unit>
    suspend fun deleteMeal(mealId: String): Resource<Unit>
    suspend fun getMealsForUser(userId: String): Resource<List<Meal>>
    suspend fun getMealDetails(mealId: String): Resource<Meal?>
}