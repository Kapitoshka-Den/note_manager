package com.example.notes.screens.notesscreen

import com.example.notes.data.datasource.database.notes.NotesEntity

sealed class NotesScreenState {
    data class NotesList(var notes: MutableList<NotesEntity>? = null):NotesScreenState()

}