package com.shifat.smarthallcatering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.shifat.smarthallcatering.ui.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            //EditCategoryScreen(category = DataSource.category, onAddProduct = {});
        Navigation(viewModel = viewModel)

        // OrderItemScreen(foodItem = DataSource.foodItem)
        //   OrderListScreen(orderList = DataSource.orderList)
        // ProviderHomeScreen(provider = DataSource.provider)
         // CustomerHomeScreen(customer = DataSource.customer)
        //  InsideShopScreen(modifier = Modifier.fillMaxSize(), provider = DataSource.provider )
        }
    }
}
