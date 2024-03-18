package com.shifat.smarthallcatering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHallCateringApp()
            //EditCategoryScreen(category = DataSource.category, onAddProduct = {});
//        Navigation(viewModel = viewModel)

        // OrderItemScreen(foodItem = DataSource.foodItem)
        //   OrderListScreen(orderList = DataSource.orderList)
        // ProviderHomeScreen(provider = DataSource.provider)
         // CustomerHomeScreen(customer = DataSource.customer)
        //  InsideShopScreen(modifier = Modifier.fillMaxSize(), provider = DataSource.provider )
        }
    }
}
