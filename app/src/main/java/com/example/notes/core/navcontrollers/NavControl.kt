package com.example.notes.core.navcontrollers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notes.screens.createnote.CreateNoteScreen
import com.example.notes.screens.notesscreen.NotesScreen
import com.example.notes.screens.settingscreen.SettingScreen

sealed class NavControl(val route: String) {
    object CreateNote : NavControl("createScreen")
    object NotesScreen : NavControl("notesScreen")
    object EditNote : NavControl("editScreen/")
    object Setting: NavControl("settingScreen")
}

@Composable
fun NavController(navController: NavHostController) {



    NavHost(navController = navController, startDestination = NavControl.NotesScreen.route) {
        composable(NavControl.NotesScreen.route) { NotesScreen(navController) }
        composable(NavControl.CreateNote.route) { CreateNoteScreen(navController) }
        composable(NavControl.Setting.route){ SettingScreen(navController) }
        composable(
            NavControl.EditNote.route +"{noteId}",
            arguments = listOf(navArgument("noteId") {
                defaultValue = "0"
            })
        ) { backStackEntry ->
            CreateNoteScreen(
                navController,
                backStackEntry.arguments?.getString("noteId")!!.toInt()
            )
        }
    }
}