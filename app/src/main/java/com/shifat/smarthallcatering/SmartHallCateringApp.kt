

package com.shifat.smarthallcatering

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shifat.smarthallcatering.common.snackbar.SnackbarManager
import com.shifat.smarthallcatering.data.remote.findProviderById
import com.shifat.smarthallcatering.model.user.User
import com.shifat.smarthallcatering.theme.SmartHallCateringTheme
import com.shifat.smarthallcatering.ui.screens.Screen
import com.shifat.smarthallcatering.ui.screens.customer.CustomerHomeScreen.CustomerHomeScreen
import com.shifat.smarthallcatering.ui.screens.customer.InsideShopScreen
import com.shifat.smarthallcatering.ui.screens.login.LoginScreen
import com.shifat.smarthallcatering.ui.screens.signup.SignUpScreen
import kotlinx.coroutines.CoroutineScope

@Composable
@ExperimentalMaterialApi
fun SmartHallCateringApp() {
    SmartHallCateringTheme {

        Surface(color = MaterialTheme.colors.background) {
            val appState = rememberAppState()

            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = it,
                        modifier = Modifier.padding(8.dp),
                        snackbar = { snackbarData ->
                            Snackbar(snackbarData, contentColor = MaterialTheme.colors.onPrimary)
                        }
                    )
                },
                scaffoldState = appState.scaffoldState
            ) { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = Screen.LoginScreen.name,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    smartHallCateringGraph(appState)
                }
            }
        }
    }
}


@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, snackbarManager, resources, coroutineScope) {
        SmartHallCateringAppState(scaffoldState, navController, snackbarManager, resources, coroutineScope)
    }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

@ExperimentalMaterialApi
fun NavGraphBuilder.smartHallCateringGraph(appState: SmartHallCateringAppState) {

    composable(route = Screen.LoginScreen.name){

        LoginScreen(
            openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) }
        )
    }
    composable(route = Screen.SignUpScreen.name){

        SignUpScreen(
            openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) }
        )
    }

    composable(
        route=Screen.CustomerHomeScreen.name
    ){
        CustomerHomeScreen(
            customer = User(name="Shifat"),
            onHallSelectButton = { appState.navigate("${Screen.InsideShopScreen.name}/{providerId}")
            } )
    }

    composable(
        route = "${Screen.InsideShopScreen.name}/{providerId}",
        arguments = listOf(navArgument("providerId") { type = NavType.StringType })
    ) {
            backStackEntry ->
        val providerId = backStackEntry.arguments?.getInt("providerId") ?: ""


        InsideShopScreen(
            provider = provider,
            onItemCardClick = {
                    categoryId, itemId ->
                val navigationPath = "${Screen.OrderItemScreen.name}/$providerId/$categoryId/$itemId"
                navController.navigate(navigationPath)
            }
        )
    }


//    composable(SPLASH_SCREEN) {
//        SplashScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
//    }
//
//    composable(SETTINGS_SCREEN) {
//        SettingsScreen(
//            restartApp = { route -> appState.clearAndNavigate(route) },
//            openScreen = { route -> appState.navigate(route) }
//        )
//    }
//
//    composable(STATS_SCREEN) {
//        StatsScreen()
//    }
//
//    composable(LOGIN_SCREEN) {
//        LoginScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
//    }
//
//    composable(SIGN_UP_SCREEN) {
//        SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
//    }
//
//    composable(TASKS_SCREEN) { TasksScreen(openScreen = { route -> appState.navigate(route) }) }
//
//    composable(
//        route = "$EDIT_TASK_SCREEN$TASK_ID_ARG",
//        arguments = listOf(navArgument(TASK_ID) {
//            nullable = true
//            defaultValue = null
//        })
//    ) {
//        EditTaskScreen(
//            popUpScreen = { appState.popUp() }
//        )
//    }
}
