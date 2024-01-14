package com.shifat.smarthallcatering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.ui.screens.ItemDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         ItemDetailsScreen(foodItem = DataSource.foodItem)
        //   OrderListScreen(orderList = DataSource.orderList)
        // ProviderHomeScreen(provider = DataSource.provider)
         // CustomerHomeScreen(customer = DataSource.customer)
        //  InsideShopScreen(modifier = Modifier.fillMaxSize(), provider = DataSource.provider )
        }
    }
}
