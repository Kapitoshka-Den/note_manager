package com.example.notes.screens.createnote

import com.example.notes.data.datasource.database.tasks.NotesEntity

sealed class CreateNoteState {
    data class NotesState(val notesEntity: NotesEntity = NotesEntity(title = "", text = ""))
}
