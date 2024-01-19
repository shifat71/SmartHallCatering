package com.shifat.smarthallcatering.model

data class Order(
    val id: Int=0,
    val quantity: Int=0,
    val item: FoodItem,
    val cost: Int=0,
    val isDelivered: Boolean= false,
    val orderedOn: Long = 0,
    val deliveredOn: Long = 0,
    val deliveryDate: Long = 0,
    val otp: String = "",
    val customerId: Int=0,
    val providerId: Int=0,
    val providerName: String = ""
)