package com.shifat.smarthallcatering.model

data class Cus(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val userType: String = "",
    val orders: List<String> = listOf("1", "2", "3")
)