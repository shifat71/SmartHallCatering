package com.shifat.smarthallcatering.data

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import com.shifat.smarthallcatering.model.user.UserType

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun signup(name: String, email: String, password: String, phone: String, userType: UserType, imageUri: Uri?): Resource<FirebaseUser>
    fun logout(): Resource<String>
}