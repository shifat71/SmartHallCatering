package com.shifat.smarthallcatering.data

import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.Order
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
    val firstLadiesImage = R.drawable.first_ladies_hall
    val mujtabaAliImage = R.drawable.mujtaba_ali_hall
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

    val provider = Provider(name="Shahporan Hall", categories = categories)

    val providers = listOf(
        Provider(name="Bangabandhu Hall", categories = categories),
        Provider(name="Syed Mujtaba Ali Hall", categories = categories),
        Provider(name="First Ladies Hall", categories = categories),
        Provider(name="Shahporan Hall", categories = categories),
        Provider(name="Second Ladies Hall", categories = categories)
    )


    val order = Order(item = foodItem, quantity = 5, cost = 400, otp = "124245", providerName = "Shahporan Hall",
        deliveredOn = System.currentTimeMillis() )

    val order1 = Order(
        item = foodItem, quantity = 5, cost = 400, otp = "124245", providerName = "Shahporan Hall",
        isDelivered = true,
        deliveryDate = System.currentTimeMillis()
    )

    val orderList = listOf( order, order1, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,
        order, order, order,order, order, order,order, order, order,order, order, order,)

    val customer = Customer(
        name = "Shifat",
        orders = orderList
    )


}