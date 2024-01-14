package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.user.Provider
import com.shifat.smarthallcatering.ui.components.ShopSummaryCard
import com.shifat.smarthallcatering.ui.components.category.CategoryCards

@Composable
fun InsideShopScreen(modifier: Modifier = Modifier, provider: Provider) {

            LazyColumn {
                item{
                    ShopSummaryCard(
                        shopName = provider.name,
                        shopPicture = provider.image
                    )
                }
                items(provider.categories)
                {
                    category -> CategoryCards(
                    modifier= Modifier,
                    name = category.name,
                    foodItems = category.items
                )
                    Divider( Modifier.height(3.dp) )

                }
            }
        }



@Preview(showBackground = true)
@Composable
fun InsideShopScreenPreview(){
    InsideShopScreen(provider = DataSource.provider)
}