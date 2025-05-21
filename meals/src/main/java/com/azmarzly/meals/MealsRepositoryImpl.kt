package com.azmarzly.meals

import com.azmarzly.core.Resource
import com.azmarzly.meals.model.Meal
import kotlinx.coroutines.flow.Flow

class MealsRepositoryImpl : MealsRepository {
    override fun addMeal(meal: Meal): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override fun updateMeal(meal: Meal): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteMeal(mealId: String): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override fun getMealsForUser(userId: String): Flow<List<Meal>> {
        TODO("Not yet implemented")
    }

    override fun getMealDetails(mealId: String): Flow<Meal?> {
        TODO("Not yet implemented")
    }
}