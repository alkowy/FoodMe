package com.azmarzly.meals

import com.azmarzly.core.Resource
import com.azmarzly.meals.model.Meal
import kotlinx.coroutines.flow.Flow

class MealsRepositoryImpl : MealsRepository {
    override suspend fun addMeal(meal: Meal): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateMeal(meal: Meal): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMeal(mealId: String): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealsForUser(userId: String): Resource<List<Meal>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealDetails(mealId: String): Resource<Meal?> {
        TODO("Not yet implemented")
    }
}