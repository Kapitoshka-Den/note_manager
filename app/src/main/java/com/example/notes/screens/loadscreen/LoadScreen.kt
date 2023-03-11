package com.example.notes.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.notes.screens.loadscreen.LoadScreenViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun LoadScreen(viewModel:LoadScreenViewModel = hiltViewModel(),
               navHostController: NavHostController) {
    val waitState = viewModel.waitState.collectAsState()
    LaunchedEffect(waitState){
        viewModel.CloseWait(navHostController);
    }
    if(waitState.value.isLoad){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading")
        }
    }


}