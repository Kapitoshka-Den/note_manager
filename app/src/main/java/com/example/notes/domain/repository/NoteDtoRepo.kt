package com.example.notes.domain.repository

import com.example.notes.data.datasource.database.notes.NotesEntity
import java.time.LocalDate

interface NoteDtoRepo {
    fun getNote(): NotesEntity
    fun setNote(notesEntity: NotesEntity)
    fun setTitle(title: String)
    fun setId(id: Int)
    fun setText(text: String)
    fun setDate(date:LocalDate)
    fun noteClear()
}