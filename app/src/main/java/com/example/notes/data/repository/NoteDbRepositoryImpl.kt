package com.example.notes.data.repository

import com.example.notes.data.datasource.database.notes.NotesDao
import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.domain.repository.NoteRepository
import javax.inject.Inject

class NoteDbRepositoryImpl @Inject constructor(val notesDao: NotesDao): NoteRepository {

    override fun getAllNotes (): List<NotesEntity> {
        return notesDao.getAllNotes()
    }

    override fun getNotesById(notesId: Int): NotesEntity {
        return notesDao.getNotesById(notesId)
    }

    override fun insertNotes(notesEntity: NotesEntity) {
        notesDao.insertNotes(notesEntity)
    }

    override fun deleteNote(notesEntity: NotesEntity) {
        notesDao.deleteNote(notesEntity)
    }
}