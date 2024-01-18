package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem
import com.shifat.smarthallcatering.ui.components.category.ItemDetailsCard
import com.shifat.smarthallcatering.ui.components.purchase.OrderCard

@Composable
fun OrderItemScreen(
    modifier: Modifier = Modifier,
    onOrderButtonClicked: () -> Unit = {},
    foodItem : FoodItem) {

    Column(modifier){
        ItemDetailsCard(Modifier.weight(.85F), foodItem)
        OrderCard(
            modifier = modifier,
            price = foodItem.price,
            onOrderButtonClicked= onOrderButtonClicked
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PurPrev() {

    val test = DataSource.foodItem

    OrderItemScreen(Modifier, foodItem =test )

}

