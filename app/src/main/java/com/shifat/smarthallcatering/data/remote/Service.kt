package com.shifat.smarthallcatering.data.remote

import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.Order
import kotlin.random.Random


fun createOrder(
    quantity: Int,
    item: FoodItem,
    customerId: Int,
): Order {

    /* To Do
    1. Will Call generateOTP()
    2. Update the OTP to Order
    3. Will Add The Order to Firebase
     */
    val price = item.price
    val cost = price * quantity
    val otp = generateOTP(6)
    val order = Order(
        quantity = quantity,
        cost = cost,
        item = item,
        providerId = item.providerId,
        customerId = customerId,
        otp = otp
    )
    saveOrder(order)
    return order
}

fun generateOTP(length: Int) : String {

        if (length <= 0) {
            throw IllegalArgumentException("OTP length must be greater than 0")
        }

        val otpChars = "0123456789"
        val random = Random.Default
        val otp = StringBuilder()

        repeat(length) {
            val randomIndex = random.nextInt(otpChars.length)
            otp.append(otpChars[randomIndex])
        }

        return otp.toString()
}

fun regenerateOTP() : Int {
    /* TO DO
    If User Forgets OTP or Loses it, this function will regenerate OTP
     */
    return 0;
}



