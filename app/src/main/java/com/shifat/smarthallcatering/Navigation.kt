package com.shifat.smarthallcatering

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shifat.smarthallcatering.data.remote.findCustomerById
import com.shifat.smarthallcatering.data.remote.findFoodItemById
import com.shifat.smarthallcatering.data.remote.findProviderById
import com.shifat.smarthallcatering.ui.screens.CustomerHomeScreen
import com.shifat.smarthallcatering.ui.screens.InsideShopScreen
import com.shifat.smarthallcatering.ui.screens.OrderCompleteScreen
import com.shifat.smarthallcatering.ui.screens.OrderItemScreen
import com.shifat.smarthallcatering.ui.screens.Screen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {


    NavHost(
        navController = navController,
        startDestination = "${Screen.CustomerHomeScreen.name}/0",  // Customer? CustomerHomeScreen : ProviderHomeScreen
        modifier = Modifier.fillMaxSize()
    ) {

        composable(
            route="${Screen.CustomerHomeScreen.name}/{customerId}",
            arguments = listOf( navArgument("customerId"){ type = NavType.IntType} )
        ){
            backStackEntry ->
            val customerId = backStackEntry.arguments?.getInt("customerId") ?: 0
            val customer = findCustomerById(customerId)
            CustomerHomeScreen(
                customer = customer,
                // Get a Category ID as a callback
                onHallSelectButton = {
                    categoryId ->
                    val navigationPath = "${Screen.InsideShopScreen.name}/$categoryId"
                    navController.navigate(navigationPath) }
                )
        }

        composable(
            route = "${Screen.InsideShopScreen.name}/{providerId}",
            arguments = listOf(navArgument("providerId") { type = NavType.IntType })
        ) {
                backStackEntry ->
            val providerId = backStackEntry.arguments?.getInt("providerId") ?: 0
            val provider = findProviderById(providerId)

            InsideShopScreen(
                provider = provider,
                onItemCardClick = {
                                  categoryId, itemId ->
                    val navigationPath = "${Screen.OrderItemScreen.name}/$providerId/$categoryId/$itemId"
                    navController.navigate(navigationPath)
                }
            )
        }

        composable(
            route = "${Screen.OrderItemScreen.name}/{providerId}/{categoryId}/{itemId}",
            arguments = listOf(
                navArgument("providerId"){ type = NavType.IntType},
                navArgument("categoryId"){ type = NavType.IntType},
                navArgument("itemId"){ type = NavType.IntType}
            )
        ){
            backStackEntry ->
            val providerId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
            val foodItem = findFoodItemById(providerId, categoryId, itemId)
            OrderItemScreen(
                foodItem = foodItem,
                onOrderButtonClicked = {
                    navController.navigate(Screen.OrderCompleteScreen.name)
                })
        }

        composable(route = Screen.OrderCompleteScreen.name){
            backStackEntry ->
            OrderCompleteScreen(
                onMoreItems = {
                    Log.d("shona shoan","haha")
                    navController.popBackStack()
                    navController.popBackStack()
                }
            )
        }

        }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    CustomerHomeScreen(
        customer = findCustomerById(0),
        // Get a Category ID as a callback
        onHallSelectButton = {
                categoryId -> }
    )
}