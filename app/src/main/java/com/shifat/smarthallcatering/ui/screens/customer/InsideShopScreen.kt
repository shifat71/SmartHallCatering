package com.shifat.smarthallcatering.ui.screens.customer

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.ui.components.ShopSummaryCard
import com.shifat.smarthallcatering.ui.components.category.CategoryCard

@Composable
fun InsideShopScreen(
    modifier: Modifier = Modifier,
    provider: Provider,
    onItemCardClick: (categoryId: String, itemId: String) -> Unit = { categoryId, itemId -> }
    ) {

            LazyColumn {
                item{
                    ShopSummaryCard(
                        shopName = provider.name,
                        shopPicture = provider.imageUri
                    )
                }
                items(provider.categories)
                {
                    category -> CategoryCard(
                    modifier= Modifier,
                    name = category.name,
                    foodItems = category.items){
                        itemId -> onItemCardClick(category.id, itemId)
                }
                    HorizontalDivider(Modifier.height(3.dp))
                }
                }
            }


@Preview(showBackground = true)
@Composable
fun InsideShopScreenPreview(){
    InsideShopScreen(provider = DataSource.provider)
}