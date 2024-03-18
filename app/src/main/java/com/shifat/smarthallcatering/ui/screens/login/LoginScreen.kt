package com.shifat.smarthallcatering.ui.screens.login



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
import com.example.makeitso.common.composable.BasicTextButton
import com.example.makeitso.common.composable.BasicToolbar
import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.common.composable.EmailField
import com.shifat.smarthallcatering.common.composable.PasswordField
import com.shifat.smarthallcatering.common.ext.basicButton
import com.shifat.smarthallcatering.common.ext.fieldModifier
import com.shifat.smarthallcatering.common.ext.textButton


@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState

    LoginScreenContent(
        uiState = uiState,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onSignInClick = { viewModel.onSignInClick(openAndPopUp) },
        onSignUpClick = { viewModel.onSignUpClick(openAndPopUp) },
        onForgotPasswordClick = viewModel::onForgotPasswordClick
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {

    BasicToolbar(R.string.login_details)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(uiState.email, onEmailChange, Modifier.fieldModifier())
        PasswordField(uiState.password, onPasswordChange, Modifier.fieldModifier())

        BasicButton(R.string.sign_in, Modifier.basicButton()) { onSignInClick() }
        BasicButton(R.string.sign_up, Modifier.basicButton()) { onSignUpClick() }
        BasicTextButton(R.string.forgot_password, Modifier.textButton()) {
            onForgotPasswordClick()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val uiState = LoginUiState(
        email = "email@test.com"
    )

//    MakeItSoTheme {
//        LoginScreenContent(
//            uiState = uiState,
//            onEmailChange = { },
//            onPasswordChange = { },
//            onSignInClick = { },
//            onForgotPasswordClick = { }
//        )
//    }
}
