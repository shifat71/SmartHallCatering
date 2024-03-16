package com.shifat.smarthallcatering.ui.components.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem


@Composable
fun ItemsCard(
    foodItems: List<FoodItem>,
    onItemCardClick: ( itemId: Int) -> Unit = { itemId -> }
) {
    Column {

        for (item in foodItems) {
            ItemCard(item, modifier = Modifier.clickable {
                onItemCardClick(item.id)
            }
            )
            HorizontalDivider()
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemsCardPreview() {
    ItemsCard(foodItems = DataSource.foodItems)
}