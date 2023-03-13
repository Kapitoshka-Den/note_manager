package com.example.notes.screens.notesscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import com.example.notes.screens.notesscreen.views.NoteItem
import java.time.LocalDate
import java.util.Date

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesScreen(
    navHostController: NavHostController,
    viewModel: NotesScreenViewModel = hiltViewModel()
) {

    val notesList = viewModel.notesList.collectAsState()

    LaunchedEffect(notesList) {
        viewModel.getNotes()
        notesList.value?.sortBy { it.dateOfCompletion }
    }

    LazyColumn {
        notesList.value?.groupBy { it.dateOfCompletion }?.forEach { (initial,notes) ->
            stickyHeader{
                Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.secondaryVariant)) {
                    Text(text = initial.toString(), fontSize = 20.sp, modifier = Modifier.padding(10.dp))
                }
            }
            items(notes){note->
                NoteItem(note = note, viewModel = viewModel, navHostController = navHostController)
            }
        }
    }
}
