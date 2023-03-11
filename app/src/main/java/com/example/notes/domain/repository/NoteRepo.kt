package com.example.notes.domain.repository

import com.example.notes.data.datasource.database.tasks.NotesEntity

interface NoteRepo {
    fun getNote():NotesEntity

    fun setTitle(title:String)

    fun setText(text:String)

}