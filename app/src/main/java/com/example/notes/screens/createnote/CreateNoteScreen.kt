package com.example.notes.screens.createnote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun CreateNoteScreen(
    navControl: NavHostController,
    viewModel: CreateNoteViewModel = hiltViewModel()
) {
    val noteState = viewModel.note.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = noteState.value.title,
            onValueChange = { viewModel.updateTitle(it) },
            label = { Text(text = "Название заметки") })
        OutlinedTextField(
            value = noteState.value.text,
            onValueChange = { viewModel.updateText(it) },
            label = { Text(text = "Текст заметки") })
    }
}