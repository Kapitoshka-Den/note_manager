package com.example.notes.screens.notesscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notes.core.navcontrollers.NavControl

@Composable
fun NotesScreen(
    navHostController: NavHostController,
    viewModel: NotesScreenViewModel = hiltViewModel()
) {

    val notesList = viewModel.notesList.collectAsState()
    LaunchedEffect(notesList) {
        viewModel.getNotes()
    }

    LazyColumn {
        notesList.value?.forEach { note ->
            item {
                Card(modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(3.dp)
                    .clickable {
                        navHostController.navigate(NavControl.CreateNote.route)
                    }
                    .border(2.dp, color = Color.Gray)) {
                    Row(
                        modifier = Modifier.fillParentMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = note.title, fontSize = 18.sp)
                        IconButton(onClick = { viewModel.deleteNote(note)
                                             }, modifier = Modifier) {
                            Icon(Icons.Filled.Delete, contentDescription = "remove note", tint = Color.Red)
                        }
                    }
                }
            }
        }
    }
}