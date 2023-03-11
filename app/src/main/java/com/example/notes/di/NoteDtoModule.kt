package com.example.notes.di

import com.example.notes.data.repository.NoteRepoImpl
import com.example.notes.domain.repository.NoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NoteDtoModule {

    @Binds
    @Singleton
    abstract fun noteBinds(noteRepo: NoteRepoImpl):NoteRepo
}