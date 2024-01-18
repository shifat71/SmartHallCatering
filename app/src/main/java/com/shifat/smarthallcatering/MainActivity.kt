package com.shifat.smarthallcatering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        Navigation()
        // OrderItemScreen(foodItem = DataSource.foodItem)
        //   OrderListScreen(orderList = DataSource.orderList)
        // ProviderHomeScreen(provider = DataSource.provider)
         // CustomerHomeScreen(customer = DataSource.customer)
        //  InsideShopScreen(modifier = Modifier.fillMaxSize(), provider = DataSource.provider )
        }
    }
}
