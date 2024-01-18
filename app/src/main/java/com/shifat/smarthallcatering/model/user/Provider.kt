package com.shifat.smarthallcatering.model.user

import com.shifat.smarthallcatering.model.Category

data class Provider(
    val id: Int=0,
    val name: String,
    val image: Int=0,
    val username: String = "",
    val password: String = "",
    /* Contains all customers, second value is true if customer is validated by Provider */
    val validCustomers: Pair<Customer,Boolean>? = null,
    val categories: List<Category>,
    // val orderList: List<Order>? = null
)