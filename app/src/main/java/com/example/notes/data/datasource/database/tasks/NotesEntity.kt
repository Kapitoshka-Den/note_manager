package com.example.notes.data.datasource.database.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NotesEntity.NOTE_TABLE_NAME)
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NOTE_ID_COLUMN)
    val id: Int = 0,
    @ColumnInfo(name = NOTE_TITLE_COLUMN)
    var title: String,
    @ColumnInfo(name = NOTE_TEXT_COLUMN)
    var text: String
) {
    companion object {
        const val NOTE_TABLE_NAME:String = "notes"

        const val NOTE_ID_COLUMN: String = "note_id"
        const val NOTE_TITLE_COLUMN: String = "note_title"
        const val NOTE_TEXT_COLUMN: String = "note_text"
    }
}

