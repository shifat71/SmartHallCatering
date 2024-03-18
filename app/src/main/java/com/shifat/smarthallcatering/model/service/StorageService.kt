package com.shifat.smarthallcatering.model.service

import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.user.User
import com.shifat.smarthallcatering.model.user.UserType
import kotlinx.coroutines.flow.Flow


interface StorageService {

    val providers: Flow< List<User> >
    suspend fun getUserType(): UserType
    suspend fun getFoodItems(categoryId: String): Flow< List<FoodItem> >
    suspend fun getItemDetails(itemId: String): FoodItem?
    suspend fun addFoodItem(item: FoodItem): String
    suspend fun updateFoodItem(itemId: String, updatedItem: FoodItem): Unit

    suspend fun getCategories(providerId: String): Flow< List<Category> >

//    suspend fun registerProvider(provider: Provider): String
//
//    suspend fun registerCustomer(customer: Customer): String

    suspend fun registerUser(user: User) : String

    suspend fun addCategory(providerId: String, category: Category): String

    /*
    suspend fun getTask(taskId: String): Task?
    suspend fun save(task: Task): String
    suspend fun update(task: Task)
    suspend fun delete(taskId: String)
    suspend fun getCompletedTasksCount(): Int
    suspend fun getImportantCompletedTasksCount(): Int
    suspend fun getMediumHighTasksToCompleteCount(): Int

     */

}
