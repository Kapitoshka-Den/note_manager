package com.example.notes.di

import com.example.notes.data.repository.NoteDtoRepoImpl
import com.example.notes.domain.repository.NoteDtoRepo
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
    abstract fun noteBinds(noteRepo: NoteDtoRepoImpl):NoteDtoRepo
}