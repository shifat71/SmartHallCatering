//package com.shifat.smarthallcatering.ui.screens.signup
//
//import android.net.Uri
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.RadioButton
//import androidx.compose.material3.RadioButtonDefaults
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.core.net.toUri
//import androidx.navigation.NavHostController
//import coil.compose.rememberAsyncImagePainter
//import com.shifat.smarthallcatering.data.Resource
//import com.shifat.smarthallcatering.model.user.UserType
//import com.shifat.smarthallcatering.ui.auth.AuthViewModel
//import com.shifat.smarthallcatering.ui.screens.Screen
//
//@Composable
//fun SignUpScreen(viewModel: AuthViewModel?, navController: NavHostController) {
//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var phone by remember { mutableStateOf("") }
//    var userType by remember { mutableStateOf(UserType.Customer) }
//    var imageUri by remember { mutableStateOf<Uri?>("".toUri()) }
//    val signupFlow = viewModel?.signupFlow?.collectAsState()
//
//    val galleryLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent(),
//        onResult = { uri ->
//            uri?.let {
//                imageUri = it
//            }
//        }
//    )
//
//    Column{
//
//        Surface(
//            shape = RoundedCornerShape(5.dp),
//            border = BorderStroke(1.dp, Color.Black),
//            modifier = Modifier.padding(5.dp)
//        ) {
//            imageUri?.let {
//                Image(
//                    painter = rememberAsyncImagePainter(imageUri),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(400.dp, 200.dp)
//                )
//            }
//
//            Box(
//                modifier = Modifier
//                    .padding(
//                        top = 85.dp,
//                        start = 140.dp
//                    )
//                    .clip(RoundedCornerShape(10.dp))
//                    .background(Color.LightGray)
//                    .alpha(.6f)
//            ) {
//                Text(
//                    modifier = Modifier
//                        .clickable {
//                            galleryLauncher.launch("image/*")
//                        }
//                        .padding(10.dp),
//                    text = "Pick Image"
//                )
//
//            }
//        }
//
//        TextField(
//            value = name,
//            onValueChange = {it -> name = it},
//            label = { Text("Name") }
//        )
//
//        TextField(
//            value = email,
//            onValueChange = {it -> email = it},
//            label = { Text("Email") }
//        )
//
//        TextField(
//            value = password,
//            onValueChange = {it -> password = it},
//            label = { Text("Password") }
//        )
//
//        Text(text = "User Type")
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Row {
//            RadioButton(
//                selected = userType == UserType.Customer,
//                onClick = { userType = UserType.Customer },
//                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
//            )
//            Text(text = "Customer")
//
//            RadioButton(
//                selected = userType == UserType.Provider,
//                onClick = { userType = UserType.Provider },
//                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
//            )
//            Text(text = "Provider")
//        }
//
//        Button(
//            onClick = {
//                viewModel?.signup(name, email, password, phone, userType, imageUri)
//            }
//        ) {
//            Text("Sign Up")
//        }
//    }
//
//    signupFlow?.value?.let {
//        when(it) {
//            is Resource.Failure -> {
//                val context = LocalContext.current
//                Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
//            }
//            Resource.Loading-> {
//                CircularProgressIndicator()
//            }
//            is Resource.Success -> {
//                LaunchedEffect(Unit) {
//
//                    navController.navigate(Screen.LoginScreen.name){
//                        popUpTo(Screen.LoginScreen.name) {
//                            inclusive = true
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewSignUpScreen() {
//    SignUpScreen(null, NavHostController(LocalContext.current))
//}
