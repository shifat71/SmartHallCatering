package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem

@Composable
fun EditItemScreen(item: FoodItem){

    Column{

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add an Image")
        }

        TextField(value = "Title", onValueChange = {}
        )

        TextField(value = "Description", onValueChange = {}
        )

    }

}


@Preview(showBackground = true)
@Composable
fun EditItemScreenPreview(){
    EditItemScreen(item = DataSource.foodItem)
}