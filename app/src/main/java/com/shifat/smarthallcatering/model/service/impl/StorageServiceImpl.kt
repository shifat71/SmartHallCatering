package com.shifat.smarthallcatering.model.service.impl

import androidx.compose.ui.util.trace
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import com.google.firebase.firestore.toObject
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.service.AuthService
import com.shifat.smarthallcatering.model.service.StorageService
import com.shifat.smarthallcatering.model.user.User
import com.shifat.smarthallcatering.model.user.UserType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageServiceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: AuthService
) : StorageService {

    override suspend fun getUserType(): UserType {
        val userId = auth.currentUserId
        val doc = firestore.collection("users").document(userId).get().await()
        val userType = doc.getString("userType")
        return UserType.valueOf(userType!!)
    }

    /*
    @OptIn(ExperimentalCoroutinesApi::class)
    override val tasks: Flow<List<Task>>
        get() =
            auth.currentUser.flatMapLatest { user ->
                firestore
                    .collection(TASK_COLLECTION)
                    .whereEqualTo(USER_ID_FIELD, user.id)
                    .orderBy(CREATED_AT_FIELD, Query.Direction.DESCENDING)
                    .dataObjects()
            }
    */

    @OptIn(ExperimentalCoroutinesApi::class)
    override val providers: Flow< List<User> >
        get() =
            auth.currentUser.flatMapLatest { user ->
                firestore
                    .collection(USER_COLLECTION)
                    .whereEqualTo("userType", UserType.Provider.name)
                    .dataObjects()
            }

    override suspend fun getCategories(providerId: String): Flow< List<Category> > =
                firestore
                    .collection(CATEGORY_COLLECTION)
                    .whereEqualTo("providerId", providerId)
                    .dataObjects()

    override suspend fun getFoodItems(categoryId: String): Flow< List<FoodItem> > =
        firestore
            .collection(FOOD_ITEM_COLLECTION)
            .whereEqualTo("categoryId", categoryId)
            .dataObjects()

    override suspend fun getItemDetails(itemId: String): FoodItem? =
        firestore.collection(FOOD_ITEM_COLLECTION).document(itemId).get().await().toObject()


    override suspend fun addFoodItem(item: FoodItem): String =
        trace(ADD_ITEM_TRACE) {
            firestore.collection(FOOD_ITEM_COLLECTION).add(item).await().id
        }

    override suspend fun updateFoodItem(itemId: String, updatedItem: FoodItem): Unit {
        trace(UPDATE_ITEM_TRACE) {
            firestore.collection(FOOD_ITEM_COLLECTION).document(itemId).set(updatedItem).await()
        }
    }

    /*
    override suspend fun getTask(taskId: String): Task? =
        firestore.collection(TASK_COLLECTION).document(taskId).get().await().toObject()
     */
//
//    override suspend fun registerProvider(provider: Provider): String =
//        trace(SAVE_PROVIDER_TRACE) {
//            val prov = object {
//                val name = provider.name
//                val email = provider.email
//                val username = provider.username
//
//                val phone = provider.phone
//            }
//            firestore.collection(PROVIDER_COLLECTION).add(prov).await().id
//        }
//    override suspend fun registerCustomer(customer: Customer): String =
//        trace(SAVE_CUSTOMER_TRACE) {
//            firestore.collection(CUSTOMER_COLLECTION).add(customer).await().id
//        }
    override suspend fun registerUser(user: User): String =
        trace(SAVE_USER_TRACE) {
            firestore.collection(USER_COLLECTION).add(user).await().id
        }

    override suspend fun addCategory(providerId: String, category: Category): String =
        trace(SAVE_CATEGORY_TRACE) {
            firestore.collection(PROVIDER_COLLECTION).document(providerId).collection(CATEGORY_COLLECTION).add(category).await().id
        }


    companion object {
        private const val SAVE_USER_TRACE ="saveUser"
        private const val ADD_ITEM_TRACE ="addItem"
        private const val UPDATE_ITEM_TRACE="updateItem"
        private const val USER_COLLECTION="users"
        private const val PROVIDER_COLLECTION = "providers"
        private const val SAVE_CATEGORY_TRACE = "saveCategory"
        private const val CATEGORY_COLLECTION = "categories"
        private const val USER_ID_FIELD = "userId"
        private const val FOOD_ITEM_COLLECTION ="items"

    }
}
