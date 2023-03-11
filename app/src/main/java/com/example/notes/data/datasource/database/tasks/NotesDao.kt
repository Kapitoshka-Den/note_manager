package com.example.notes.data.datasource.database.tasks

import androidx.room.*

@Dao
interface NotesDao {

    @Query("SELECT ${NotesEntity.NOTE_TITLE_COLUMN} " +
            "FROM ${NotesEntity.NOTE_TABLE_NAME}")
    fun getAllShortNotes(): List<String>

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