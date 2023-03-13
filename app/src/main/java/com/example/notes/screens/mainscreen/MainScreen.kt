package com.example.notes.screens.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.notes.core.navcontrollers.NavControl
import com.example.notes.core.navcontrollers.NavController

@Composable
fun MainScreen(
    navHostController: NavHostController,
    isDark: () -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val childController = rememberNavController()

    val childDestination by childController.currentBackStackEntryAsState()
    val currentChildDestination = childDestination?.destination?.hierarchy

    Scaffold(
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    IconButton(onClick = {
                        if(currentChildDestination?.any { it.route == NavControl.Setting.route } == false)
                            childController.navigate(NavControl.Setting.route)
                        else
                            childController.popBackStack()
                    }) {
                        if(currentChildDestination?.any { it.route == NavControl.Setting.route } == false)
                            Icon(Icons.Filled.Settings, contentDescription = "setting")
                        else
                            Icon(Icons.Filled.ArrowBack, contentDescription = "back")

                    }
                    IconButton(onClick = { isDark() }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "change theme")
                    }
                }
            }
        },
        content = { padding ->
            Column(
                Modifier
                    .padding(padding)
            ) {
                NavController(childController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (currentChildDestination?.any { it.route == NavControl.CreateNote.route } == false) {
                    childController.navigate(NavControl.CreateNote.route)
                } else {
                    viewModel.saveNote(childController)
                }
            }) {
                if (currentChildDestination?.any { it.route == NavControl.CreateNote.route } == false) {
                    Icon(Icons.Filled.Add, contentDescription = "add note")
                } else {
                    Icon(Icons.Filled.Create, contentDescription = "save note")
                }
            }
        },
        isFloatingActionButtonDocked = true,
    )

}