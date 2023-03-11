package com.example.notes.di

import android.content.ContentValues
import android.content.Context
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notes.data.datasource.database.DataBase
import com.example.notes.data.datasource.database.tasks.NotesDao
import com.example.notes.data.datasource.database.tasks.NotesEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import javax.security.auth.callback.Callback

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context):DataBase =
        Room.databaseBuilder(
            context = context,
            DataBase::class.java,
            "notes_database"
        ).fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val cv:ContentValues = ContentValues()
                    cv.put(NotesEntity.NOTE_TEXT_COLUMN,"test")
                    cv.put(NotesEntity.NOTE_TITLE_COLUMN,"title")

                    db.insert(NotesEntity.NOTE_TABLE_NAME, conflictAlgorithm = OnConflictStrategy.REPLACE, values = cv)
                }
            })
            .build()

    @Provides
    @Singleton
    fun provideNote(dataBase: DataBase):NotesDao = dataBase.notesDao()
}