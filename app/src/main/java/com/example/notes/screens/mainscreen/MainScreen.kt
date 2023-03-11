package com.example.notes.screens.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.notes.core.navcontrollers.NavControl
import com.example.notes.core.navcontrollers.NavController

@Composable
fun MainScreen(
    navHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val childController = rememberNavController()

    val childDestination by childController.currentBackStackEntryAsState()
    val currentChildDestination = childDestination?.destination
    val selectedItem =
        currentChildDestination?.hierarchy?.any { it.route == NavControl.CreateNote.route }

    Scaffold(
        bottomBar = {
            BottomAppBar(cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))) {

            }
        },
        content = { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .padding(10.dp)
            ) {
                NavController(childController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (selectedItem == true) {
                    viewModel.saveNote(childController)
                } else {
                    childController.navigate(NavControl.CreateNote.route)
                }
            }) {
                if (selectedItem == true) {
                    Icon(Icons.Filled.Create, contentDescription = "save note")
                } else {
                    Icon(Icons.Filled.Add, contentDescription = "add note")
                }
            }
        },
        isFloatingActionButtonDocked = true,
    )

}