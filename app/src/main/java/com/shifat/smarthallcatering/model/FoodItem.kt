package com.shifat.smarthallcatering.model

import com.google.firebase.firestore.DocumentId

data class FoodItem(
    @DocumentId val id: String = "",
    val title:String="",
    val desc: String="",
    val price: Int=0,
    val image: String="",
    val providerId: String ="",
    val categoryId: String=""
)