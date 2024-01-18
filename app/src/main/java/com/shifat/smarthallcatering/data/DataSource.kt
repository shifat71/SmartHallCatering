package com.shifat.smarthallcatering.data

import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.Order
import com.shifat.smarthallcatering.model.user.Customer
import com.shifat.smarthallcatering.model.user.Provider
import com.shifat.smarthallcatering.textGen

object DataSource {


    /* To Do - Functions for Bipul

    1. Customer & Provider Registration and Login
    2. Retrieve All Categories for a Customer
    3. Retrieve All Items Inside a Category
    4. Retrieve All User that Requested to Subscribe
    5. Function to Accept a User to a Store
    6. Retrieve All Providers
    7. Retrieve Food Items Under A Category
    8. Edit & Adds Food Items, Categories

     */

    val desc = textGen(200)

    val title = "Food Item Name"
    val price = 30;
    val image = R.drawable.foodpic
    val hallImage = R.drawable.shahporan

    val foodItem = FoodItem(title = title, desc = desc, price =  price, image = image)
    val foodItems = listOf(
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image),
        FoodItem(title = title, desc = desc, price =  price, image = image)
    )


    val category = Category(name = "Category 2", items = foodItems)
    val categories = listOf(
        Category(name = "Category 1", items = foodItems),
        Category(name = "Category 2", items = foodItems)
    )

    val provider = Provider(name="Shahporan Hall", categories = categories, image = hallImage)

    val providers = listOf(
        Provider(name="Bangabandhu Hall", categories = categories, image = hallImage),
        Provider(name="Syed Mustaba Ali Hall", categories = categories, image = image),
        Provider(name="Shahporan Hall", categories = categories, image = hallImage),
        Provider(name="First Ladies Hall", categories = categories, image = image),
        Provider(name="Second Ladies Hall", categories = categories, image = hallImage)
    )

    val customer = Customer(
        firstName = "Shifat",
        lastName = "Rahman",
        subscribedProviders = providers
        )
    val order = Order(item = foodItem, quantity = 5)
    val orderList = listOf( order, order, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,)



}