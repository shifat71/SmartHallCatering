package com.shifat.smarthallcatering.data.remote

import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.model.Order
import kotlin.random.Random


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



