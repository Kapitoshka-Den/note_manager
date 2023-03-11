package com.example.notes.core.navcontrollers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.screens.createnote.CreateNoteScreen
import com.example.notes.screens.notesscreen.NotesScreen

sealed class NavControl(val route:String) {
    object CreateNote:NavControl("createScreen")
    object NotesScreen:NavControl("notesScreen")
    object EditNote:NavControl("editScreen/{noteId}")
}

@Composable
fun NavController(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavControl.NotesScreen.route){
        composable(NavControl.NotesScreen.route){ NotesScreen(navController)}
        composable(NavControl.CreateNote.route){ CreateNoteScreen(navController) }
        composable(NavControl.CreateNote.route){ CreateNoteScreen(navController) }
    }
}