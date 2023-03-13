package com.example.notes.screens.createnote

import com.example.notes.data.datasource.database.notes.NotesEntity
import java.time.LocalDate

sealed class CreateNoteState {
    data class NotesState(
        var notesEntity: NotesEntity = NotesEntity(
            title = "",
            text = "",
            dateOfCompletion = LocalDate.now()
        )
    )
}
