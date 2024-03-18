
package com.shifat.smarthallcatering.ui.screens.signup

import android.net.Uri
import androidx.core.net.toUri
import com.shifat.smarthallcatering.model.user.UserType

data class SignUpUiState(
  val name: String = "",
  val email: String = "",
  val phone: String ="",
  val imageUri: Uri = "".toUri(),
  val userType: UserType = UserType.Customer,
  val password: String = "",
  val repeatPassword: String = ""
)
