package com.example.notes.core.navcontrollers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.screens.LoadScreen
import com.example.notes.screens.mainscreen.MainScreen

sealed class GlobalNavControl(val route:String) {
    object MainScreen: NavControl("mainScreen")
    object LoadScreen:NavControl("loadScreen")
}

@Composable
fun GlobalNavController(){
    val navControl = rememberNavController()

    NavHost(navController = navControl, startDestination = GlobalNavControl.LoadScreen.route){
        composable(GlobalNavControl.LoadScreen.route){ LoadScreen(navHostController = navControl)}
        composable(GlobalNavControl.MainScreen.route){ MainScreen(navHostController = navControl)}
    }
}