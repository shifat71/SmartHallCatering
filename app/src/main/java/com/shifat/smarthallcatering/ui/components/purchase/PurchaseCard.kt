package com.shifat.smarthallcatering.ui.components.purchase

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.ui.screens.ItemDetailsScreen

@Composable
fun PurchaseCard(modifier: Modifier= Modifier, foodItem : FoodItem) {

    Column(modifier){
        ItemDetailsScreen(Modifier.weight(.85F), foodItem)
        OrderCard(foodItem.price)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PurPrev() {

    val test = DataSource.foodItem

    PurchaseCard(Modifier, foodItem =test )

}

