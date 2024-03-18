
package com.shifat.smarthallcatering.ui.screens.signup

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.common.composable.BasicButton
import com.example.makeitso.common.composable.BasicToolbar
import com.example.makeitso.common.composable.UserTypeRadioButton
import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.common.composable.EmailField
import com.shifat.smarthallcatering.common.composable.ImageField
import com.shifat.smarthallcatering.common.composable.NameField
import com.shifat.smarthallcatering.common.composable.PasswordField
import com.shifat.smarthallcatering.common.composable.PhoneField
import com.shifat.smarthallcatering.common.composable.RepeatPasswordField
import com.shifat.smarthallcatering.common.ext.basicButton
import com.shifat.smarthallcatering.common.ext.fieldModifier
import com.shifat.smarthallcatering.model.user.UserType

@Composable
fun SignUpScreen(
  openAndPopUp: (String, String) -> Unit,
  viewModel: SignUpViewModel = hiltViewModel()
) {
  val uiState by viewModel.uiState

  SignUpScreenContent(
    uiState = uiState,
    onNameChange = viewModel::onNameChange,
    onPhoneChange = viewModel::onPhoneChange,
    onUserTypeChange = viewModel::onUserTypeChange,
    onImageUriChange = viewModel::onImageUriChange,
    onEmailChange = viewModel::onEmailChange,
    onPasswordChange = viewModel::onPasswordChange,
    onRepeatPasswordChange = viewModel::onRepeatPasswordChange,
    onSignUpClick = { viewModel.onSignUpClick(openAndPopUp) }
  )
}

@Composable
fun SignUpScreenContent(
  modifier: Modifier = Modifier,
  uiState: SignUpUiState,
  onNameChange: (String) -> Unit,
  onPhoneChange: (String) -> Unit,
  onUserTypeChange: (UserType) -> Unit,
  onImageUriChange: (Uri) -> Unit,
  onEmailChange: (String) -> Unit,
  onPasswordChange: (String) -> Unit,
  onRepeatPasswordChange: (String) -> Unit,
  onSignUpClick: () -> Unit
) {
  val fieldModifier = Modifier.fieldModifier()

  BasicToolbar(R.string.create_account)


  val galleryLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent(),
    onResult = { uri ->
      uri?.let {
        onImageUriChange(it)
      }
    }
  )

  Column(
    modifier = modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    ImageField(uiState.imageUri, galleryLauncher, fieldModifier)
    NameField(uiState.name, onNameChange, fieldModifier)
    EmailField(uiState.email, onEmailChange, fieldModifier)
    PhoneField(uiState.phone,onPhoneChange, fieldModifier)
    UserTypeRadioButton(uiState.userType, onUserTypeChange, fieldModifier)
    PasswordField(uiState.password, onPasswordChange, fieldModifier)
    RepeatPasswordField(uiState.repeatPassword, onRepeatPasswordChange, fieldModifier)

    BasicButton(R.string.create_account, Modifier.basicButton()) {
      onSignUpClick()
    }
  }
}



@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
  val uiState = SignUpUiState(
    email = "email@test.com"
  )

//  SmartHallCateringTheme {
//    SignUpScreenContent(
//      uiState = uiState,
//      onEmailChange = { },
//      onPasswordChange = { },
//      onRepeatPasswordChange = { },
//      onSignUpClick = { }
//    )
//  }
}
