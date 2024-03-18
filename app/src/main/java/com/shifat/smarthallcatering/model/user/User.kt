package com.shifat.smarthallcatering.model.user

import com.google.firebase.firestore.DocumentId

data class User(

    @DocumentId val id: String = "",
    val name: String="",
    val userType: UserType = UserType.Customer,
    val username: String="",
    val email: String="",
    val imageUri: String ="",
    val phone: String=""
)
