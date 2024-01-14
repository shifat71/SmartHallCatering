package com.shifat.smarthallcatering.model

import java.sql.Timestamp

data class Order(
    val id: Int=0,
    val quantity: Int=0,
    val item: FoodItem,
    val cost: Int=0,
    val isDelivered: Boolean=false,
    val date: Timestamp?=null,
    val customerId: Int=0,
    val providerId: Int=0,
)