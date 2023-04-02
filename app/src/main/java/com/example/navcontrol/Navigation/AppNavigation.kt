package com.example.navcontrol.Navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navcontrol.Screen.DataScreen
import com.example.navcontrol.Screen.HomeScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    Scaffold() {
        NavHost(navController = navController, startDestination = Screens.HOME.name) {
            composable(route = Screens.HOME.name) {
                HomeScreen(onSendClick = {
                    navController.navigate(route = Screens.DATA.name)
                },navController)
            }


            composable(
                route = Screens.DATA.name + "/{message}",
                arguments = listOf(navArgument("message") {
                type = NavType.StringType
                })
            ) {
                val message = requireNotNull(it.arguments).getString("message")
                DataScreen(onBack = {
                    navController.navigateUp()

                },message)
            }
        }
    }

}