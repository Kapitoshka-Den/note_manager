package com.example.notes.domain.repository

import com.example.notes.data.datasource.database.notes.NotesEntity

interface NoteRepository {
    fun getAllNotes(): List<NotesEntity>
    fun getNotesById(notesId: Int): NotesEntity
    fun insertNotes(notesEntity: NotesEntity)
    fun deleteNote(notesEntity: NotesEntity)
}