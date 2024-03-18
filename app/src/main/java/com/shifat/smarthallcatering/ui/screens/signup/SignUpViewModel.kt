
package com.shifat.smarthallcatering.ui.screens.signup

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.SmartHallCateringViewModel
import com.shifat.smarthallcatering.common.ext.isValidEmail
import com.shifat.smarthallcatering.common.ext.isValidPassword
import com.shifat.smarthallcatering.common.ext.passwordMatches
import com.shifat.smarthallcatering.common.snackbar.SnackbarManager
import com.shifat.smarthallcatering.model.service.AuthService
import com.shifat.smarthallcatering.model.service.StorageService
import com.shifat.smarthallcatering.model.user.User
import com.shifat.smarthallcatering.model.user.UserType
import com.shifat.smarthallcatering.ui.screens.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
  private val authService: AuthService,
  private val storageService: StorageService
) : SmartHallCateringViewModel() {
  var uiState = mutableStateOf(SignUpUiState())
    private set

  private val name
    get() = uiState.value.name

  private val imageUri
    get() = uiState.value.imageUri

  private val email
    get() = uiState.value.email

  private val phone
    get() = uiState.value.phone

  private val userType
    get() = uiState.value.userType



  private val password
    get() = uiState.value.password

  fun onNameChange(newValue: String) {
    uiState.value = uiState.value.copy(name = newValue)
  }
  fun onPhoneChange(newValue: String) {
    uiState.value = uiState.value.copy(phone = newValue)
  }

  fun onUserTypeChange(newValue: UserType) {
    uiState.value = uiState.value.copy(userType = newValue)
  }

  fun onImageUriChange(newValue: Uri) {
    uiState.value = uiState.value.copy(imageUri = newValue)
  }


  fun onEmailChange(newValue: String) {
    uiState.value = uiState.value.copy(email = newValue)
  }

  fun onPasswordChange(newValue: String) {
    uiState.value = uiState.value.copy(password = newValue)
  }

  fun onRepeatPasswordChange(newValue: String) {
    uiState.value = uiState.value.copy(repeatPassword = newValue)
  }

  fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
    if (!email.isValidEmail()) {
      SnackbarManager.showMessage(R.string.email_error)
      return
    }

    if (!password.isValidPassword()) {
      SnackbarManager.showMessage(R.string.password_error)
      return
    }

    if (!password.passwordMatches(uiState.value.repeatPassword)) {
      SnackbarManager.showMessage(R.string.password_match_error)
      return
    }

    launchCatching {
      authService.registerUser(email, password)
      val user = User(
        name = name,
        username = email,
        imageUri = imageUri.toString(),
        email = email,
        phone = phone,
        userType = userType
      )
      storageService.registerUser(user)

      if(userType == UserType.Customer) openAndPopUp(Screen.CustomerHomeScreen.name, Screen.SignUpScreen.name)
      else openAndPopUp(Screen.ProviderHomeScreen.name, Screen.SignUpScreen.name)

    }
  }
}
