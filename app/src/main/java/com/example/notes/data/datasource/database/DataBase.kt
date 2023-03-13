package com.example.notes.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notes.data.datasource.database.notes.NotesDao
import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.data.datasource.database.notes.dataconverters.DateConverter

@Database(entities = [NotesEntity::class], version = 5)
@TypeConverters(DateConverter::class)
abstract class DataBase: RoomDatabase() {
    abstract fun notesDao():NotesDao
}