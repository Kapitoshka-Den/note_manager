package com.example.notes.screens.notesscreen

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.notes.core.navcontrollers.NavControl
import com.example.notes.data.datasource.database.tasks.NotesEntity

sealed class NotesScreenState {
    data class NotesList(var notes: MutableList<NotesEntity>? = null):NotesScreenState()

}