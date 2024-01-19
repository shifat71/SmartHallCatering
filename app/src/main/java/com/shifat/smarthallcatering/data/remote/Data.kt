package com.shifat.smarthallcatering.data.remote

import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.Order
import com.shifat.smarthallcatering.model.user.Customer
import com.shifat.smarthallcatering.model.user.Provider

fun findProviderById( providerId: Int ) : Provider {
    return DataSource.provider
}

fun findCustomerById(customerId: Int) : Customer {
 return DataSource.customer
}

fun findFoodItemById(providerId: Int, categoryId: Int, itemId: Int) : FoodItem {
    return DataSource.foodItem
}

fun findCategoryById(providerId: Int, categoryId: Int) : Category {

    return DataSource.category
}

fun saveOrder( order: Order ) : Boolean
{
    /* Save A Order To Firebase */
    return false
}

fun currentUser() : Customer {
    /*
      Will return the current logged in user from firebase
     */
    return DataSource.customer
}