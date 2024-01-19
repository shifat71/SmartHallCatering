package com.shifat.smarthallcatering.model

data class FoodItem(
    val id: Int = 0,
    val title:String,
    val desc: String,
    val price: Int,
    val image: Int,
    val providerId: Int = 0,
    val categoryId: Int = 0
)