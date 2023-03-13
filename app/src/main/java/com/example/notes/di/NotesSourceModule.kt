package com.example.notes.di

import com.example.notes.core.DatabaseDataSource
import com.example.notes.data.repository.NoteDbRepositoryImpl
import com.example.notes.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NotesSourceModule {

    @Binds
    @Singleton
    @DatabaseDataSource
    abstract fun notesSourceBind(notesRepository: NoteDbRepositoryImpl): NoteRepository
}