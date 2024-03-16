package com.shifat.smarthallcatering.ui.screens.provider

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditItemScreen(item: FoodItem){

    var imageUri by remember { mutableStateOf<Uri?>("".toUri()) }
    var foodName by remember { mutableStateOf(item.title) }
    var foodDescription by remember { mutableStateOf(item.desc) }


    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                imageUri = it
            }
        }
    )


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Handle save action here
            }) {
                    Text(
                        text = "Save",
                        Modifier.padding(10.dp),
                        fontSize = 30.sp
                    )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
         it -> LazyColumn {
        item {
            Surface(
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier.padding(5.dp)
            ) {
                imageUri?.let {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(400.dp, 200.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(
                            top = 85.dp,
                            start = 140.dp
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .alpha(.6f)
                ) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                galleryLauncher.launch("image/*")
                            }
                            .padding(10.dp),
                        text = "Pick Image"
                    )

                }
            }

            OutlinedTextField(
                value = foodName,
                onValueChange = { foodName = it },
                label = { Text(text = "Item Name") },
                modifier = Modifier.padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )
            )

            OutlinedTextField(
                value = foodDescription,
                onValueChange = { foodDescription = it },
                label = { Text(text = "Food Description") },
                modifier = Modifier.padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )
            )
        }
    }
    }

}


@Preview(showBackground = true)
@Composable
fun EditItemScreenPreview(){
    EditItemScreen(item = DataSource.foodItem)
}

