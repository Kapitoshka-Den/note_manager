package com.example.notes.data.datasource.database.notes

import androidx.room.*
import com.example.notes.data.datasource.database.notes.dataconverters.DateConverter
import java.sql.Date
import java.time.LocalDate

@Entity(tableName = NotesEntity.NOTE_TABLE_NAME)
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NOTE_ID_COLUMN)
    val id: Int = 0,
    @ColumnInfo(name = NOTE_TITLE_COLUMN)
    var title: String,
    @ColumnInfo(name = NOTE_TEXT_COLUMN)
    var text: String,
    @ColumnInfo(name=NOTE_DATE_COLUMN)
    @TypeConverters(DateConverter::class)
    val dateOfCompletion: LocalDate
) {
    companion object {
        const val NOTE_TABLE_NAME:String = "notes_date_of_completion"

        const val NOTE_DATE_COLUMN: String = "note_date"
        const val NOTE_ID_COLUMN: String = "note_id"
        const val NOTE_TITLE_COLUMN: String = "note_title"
        const val NOTE_TEXT_COLUMN: String = "note_text"
    }
}

