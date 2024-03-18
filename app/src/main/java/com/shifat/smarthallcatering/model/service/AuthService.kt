
package com.shifat.smarthallcatering.model.service

import com.shifat.smarthallcatering.model.user.User
import kotlinx.coroutines.flow.Flow

interface AuthService {
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String)
    suspend fun sendRecoveryEmail(email: String)
    suspend fun registerUser(email: String, password: String): Unit
    suspend fun signOut()
}
