package com.example.notes.data.repository

import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.domain.repository.NoteDtoRepo
import java.time.LocalDate
import javax.inject.Inject

class NoteDtoRepoImpl @Inject constructor() : NoteDtoRepo {

    private var note: NotesEntity = NotesEntity(title = "", text = "", dateOfCompletion = LocalDate.now())

    override fun getNote(): NotesEntity {
        return note
    }

    override fun setNote(notesEntity: NotesEntity) {
        note = note.copy(notesEntity.id,notesEntity.title,notesEntity.text,notesEntity.dateOfCompletion)
    }

    override fun setTitle(title: String) {
        note = note.copy(title = title)
    }

    override fun setId(id: Int) {
        note = note.copy(id = id)
    }

    override fun setText(text: String) {
        note = note.copy(text = text)
    }

    override fun setDate(date: LocalDate) {
        note = note.copy(dateOfCompletion = date)
    }

    override fun noteClear() {
        note = NotesEntity(id = 0, title = "", text = "", dateOfCompletion = LocalDate.now())
    }

}