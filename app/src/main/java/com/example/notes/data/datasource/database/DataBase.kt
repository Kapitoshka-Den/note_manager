package com.example.notes.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.datasource.database.tasks.NotesDao
import com.example.notes.data.datasource.database.tasks.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun notesDao():NotesDao
}