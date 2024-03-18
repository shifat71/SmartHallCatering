package com.shifat.smarthallcatering.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Order(
    @DocumentId val id: String = "",
    val quantity: Int=0,
    val item: FoodItem,
    val cost: Int=0,
    val isDelivered: Boolean= false,
    @ServerTimestamp val orderedOn: Date = Date(),
    val deliveredOn: Long = 0,
    val deliveryDate: Long = 0,
    val otp: String = "",
    val customerId: String="",
    val providerId: String="",
    val providerName: String = ""
)