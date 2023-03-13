package com.example.notes.data.datasource.database.notes

import androidx.room.*

@Dao
interface NotesDao {

    @Query("SELECT * " +
            "FROM ${NotesEntity.NOTE_TABLE_NAME}")
    fun getAllNotes(): List<NotesEntity>

    @Query("Select * FROM ${NotesEntity.NOTE_TABLE_NAME} " +
            "where ${NotesEntity.NOTE_ID_COLUMN} = :notesId")
    fun getNotesById(notesId: Int):NotesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notesEntity:NotesEntity)

    @Delete
    fun deleteNote(notesEntity: NotesEntity)
}