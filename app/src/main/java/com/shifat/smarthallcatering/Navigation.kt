package com.shifat.smarthallcatering

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shifat.smarthallcatering.data.remote.findCustomerById
import com.shifat.smarthallcatering.data.remote.findProviderById
import com.shifat.smarthallcatering.ui.screens.CustomerHomeScreen
import com.shifat.smarthallcatering.ui.screens.InsideShopScreen
import com.shifat.smarthallcatering.ui.screens.Screen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screen.CustomerHomeScreen.name,  // Customer? CustomerHomeScreen : ProviderHomeScreen
        modifier = Modifier.fillMaxSize()  ){

        composable(route="${Screen.CustomerHomeScreen.name}/{customerId}"){
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
            InsideShopScreen(provider = provider)
        }


        }


}

