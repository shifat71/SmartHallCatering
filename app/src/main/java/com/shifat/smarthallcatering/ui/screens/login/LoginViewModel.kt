
package com.shifat.smarthallcatering.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.SmartHallCateringViewModel
import com.shifat.smarthallcatering.common.ext.isValidEmail
import com.shifat.smarthallcatering.common.snackbar.SnackbarManager
import com.shifat.smarthallcatering.model.service.AuthService
import com.shifat.smarthallcatering.model.service.StorageService
import com.shifat.smarthallcatering.model.user.UserType
import com.shifat.smarthallcatering.ui.screens.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService,
    private val storageService: StorageService
) : SmartHallCateringViewModel() {
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(R.string.email_error)
            return
        }

        if (password.isBlank()) {
            SnackbarManager.showMessage(R.string.empty_password_error)
            return
        }

        launchCatching {
            authService.authenticate(email, password)

            val userType = storageService.getUserType()

            if(userType==UserType.Customer) openAndPopUp(Screen.CustomerHomeScreen.name, Screen.LoginScreen.name)
            else openAndPopUp(Screen.ProviderHomeScreen.name, Screen.LoginScreen.name)
        }
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(Screen.SignUpScreen.name, Screen.LoginScreen.name)
    }

    fun onForgotPasswordClick() {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(R.string.email_error)
            return
        }

        launchCatching {
            authService.sendRecoveryEmail(email)
            SnackbarManager.showMessage(R.string.recovery_email_sent)
        }
    }


}
