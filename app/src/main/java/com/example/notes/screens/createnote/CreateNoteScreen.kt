package com.example.notes.screens.createnote

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun CreateNoteScreen(
    navControl: NavHostController,
    noteId: Int? = null,
    viewModel: CreateNoteViewModel = hiltViewModel(),
) {
    val noteState = viewModel.note.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(noteState) {
        if (noteId != null)
            viewModel.getNote(noteId)
        else
            viewModel.noteClear()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column() {
            IconButton(onClick = { navControl.popBackStack()}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "back")
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {

            }
            OutlinedTextField(
                value = noteState.value.title,
                onValueChange = { viewModel.updateTitle(it) },
                label = { Text(text = "Название заметки") },
                modifier = Modifier.padding(3.dp)
            )
            OutlinedTextField(
                value = noteState.value.text,
                onValueChange = { viewModel.updateText(it) },
                label = { Text(text = "Текст заметки") },
                modifier = Modifier
                    .padding(10.dp)
                    .padding(15.dp)
            )
            Row() {
                OutlinedTextField(
                    value = noteState.value.dateOfCompletion.toString(),
                    onValueChange = { viewModel.updateDate(it) },
                    label = { Text(text = "Дата выполения") },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { viewModel.showDatePicker(context) }) {
                            Icon(Icons.Filled.DateRange, contentDescription = "pick date")
                        }
                    }
                )

            }

        }
    }
}