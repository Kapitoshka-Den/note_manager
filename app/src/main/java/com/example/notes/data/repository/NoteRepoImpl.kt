package com.example.notes.data.repository

import com.example.notes.data.datasource.database.tasks.NotesEntity
import com.example.notes.domain.repository.NoteRepo
import javax.inject.Inject

class NoteRepoImpl @Inject constructor() : NoteRepo {

    private var note: NotesEntity = NotesEntity(title = "", text = "")

    override fun getNote(): NotesEntity {
        return note
    }

    override fun setTitle(title: String) {
        note = note.copy(title = title)
    }

    override fun setText(text: String) {
        note = note.copy(text = text)
    }


}