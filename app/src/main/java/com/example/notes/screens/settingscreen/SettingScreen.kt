package com.example.notes.screens.settingscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notes.core.navcontrollers.NavControl

@Composable
fun SettingScreen (navControl: NavHostController, viewModel: SettingViewModel = hiltViewModel()){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {
            viewModel.clearData()
        }) {
            Text(text = "Очистить базу данных")
        }
    }
}