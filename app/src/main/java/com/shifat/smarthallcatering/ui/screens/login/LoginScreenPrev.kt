//package com.shifat.smarthallcatering.ui.screens.login
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Button
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.shifat.smarthallcatering.data.Resource
//import com.shifat.smarthallcatering.ui.auth.AuthViewModel
//import com.shifat.smarthallcatering.ui.screens.Screen
//
//@Composable
//fun LoginScreen(viewModel: AuthViewModel?, navController: NavHostController) {
//
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    var uiState = mutableStateOf(LoginUiState())
//    private set
//
//
//    val loginFlow = viewModel?.loginFlow?.collectAsState()
//
//    Column {
//        TextField(
//            value = email,
//            onValueChange = {it -> email = it}
//        )
//        TextField(
//            value = password,
//            onValueChange = {it -> password = it}
//        )
//        Button(
//            onClick = {
//                viewModel?.login(email,password)
//            }
//        ) {
//            Text("Login")
//        }
//        Text(text = "Don't Have an Account?")
//        Button(
//            onClick = {
//                navController.navigate(Screen.SignUpScreen.name)
//            }
//        ) {
//            Text("Sign Up")
//        }
//    }
//
//
//    loginFlow?.value?.let {
//        when(it) {
//            is Resource.Failure -> {
//                val context = LocalContext.current
//                Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
//            }
//            Resource.Loading-> {
//                CircularProgressIndicator()
//            }
//            is Resource.Success -> {
//                it.result.let { user ->
//                    Toast.makeText(LocalContext.current, "Welcome ${user.email}", Toast.LENGTH_LONG).show()
//                    navController.navigate(Screen.CustomerHomeScreen.name + "/0")
//                }
//
//            }
//        }
//    }
//
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginScreenPreview()
//{
//    LoginScreen(null,  rememberNavController())
//}