package com.shifat.smarthallcatering.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.FoodItem
import com.shifat.smarthallcatering.R
import com.shifat.smarthallcatering.components.Category


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val desc = "This is a description of the Food, This is a description of the Food, Sdhas KJSd as sdj jsdj sjkdjk sk dsdkj khskjdhs kjhdsjkdh"
    val title = "Food Item Name"
    val price = 30;
    val image = painterResource(R.drawable.foodpic)

    val hhh = listOf(
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image)

    )

    val catList = listOf( "Category 1", "Category 2" )

    LazyColumn {
        items(catList)
        {
                item -> Category(name = item, foodItems = hhh)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Pre()
{
    HomeScreen(Modifier)
}