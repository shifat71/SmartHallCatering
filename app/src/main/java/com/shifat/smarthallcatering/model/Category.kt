package com.shifat.smarthallcatering.model

data class Category(
    val id: Int=0,
    val name: String,
    val items: List<FoodItem>,
   //  val provider: Provider
)