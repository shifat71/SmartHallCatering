package com.shifat.smarthallcatering.model.user

data class Customer(
    val id: Int=0,
    val firstName: String="",
    val lastName: String =" ",
    val username: String="",
    val email: String="",
    val phone: String="",
    val password: String="",
    val subscribedProviders: List<Provider>
)
