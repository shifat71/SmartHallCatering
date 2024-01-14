package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.user.Provider
import com.shifat.smarthallcatering.ui.components.ShopSummaryCard
import com.shifat.smarthallcatering.ui.components.category.CategoryCards

@Composable
fun ProviderHomeScreen(provider: Provider){
    Column {

        LazyColumn{
            item{
                Column {
                    ShopSummaryCard(
                        shopName = provider.name,
                        shopPicture = provider.image
                    )
                    Text(
                        text = "Add a Category",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 20.dp)
                            .clickable {
                                /*
                                 To Do
                                 */
                            }
                    )
                }
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
}

@Preview(showBackground = true)
@Composable
fun ProviderHomeScreenPreview()
{
    ProviderHomeScreen(provider = DataSource.provider)
}