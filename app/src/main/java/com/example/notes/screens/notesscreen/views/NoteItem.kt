package com.example.notes.screens.notesscreen.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notes.core.navcontrollers.NavControl
import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.screens.notesscreen.NotesScreenViewModel

@Composable
fun NoteItem(
    note: NotesEntity,
    viewModel: NotesScreenViewModel,
    navHostController: NavHostController
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .clickable {
                    navHostController.navigate(NavControl.EditNote.route + note.id.toString())
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(text = note.title, fontSize = 18.sp)
                Text(
                    text = note.text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxSize(0.8f)
                        .padding(start = 10.dp),
                    color = Color.Gray
                )
            }
            IconButton(onClick = {
                viewModel.deleteNote(note)
            }, modifier = Modifier) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "remove note",
                    tint = Color.Red
                )
            }
        }
    }
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 2.dp,
        color = MaterialTheme.colors.secondaryVariant
    )

}