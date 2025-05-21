package com.azmarzly.meals

import com.azmarzly.core.Resource
import com.azmarzly.meals.model.CategoryWithMeals
import com.azmarzly.meals.model.MealCategory

interface CategoriesRepository {
    suspend fun getCategoriesForUser(userId: String): Resource<List<MealCategory>>
    suspend fun getCategoryWithMeals(categoryId: String): Resource<CategoryWithMeals>
    suspend fun createCategory(category: MealCategory): Resource<Unit>
    suspend fun deleteCategory(categoryId: String): Resource<Unit>
}